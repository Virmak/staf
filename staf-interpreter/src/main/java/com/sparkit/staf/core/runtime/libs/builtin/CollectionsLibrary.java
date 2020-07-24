package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.exceptions.DictionariesShouldBeEqualException;
import com.sparkit.staf.core.runtime.libs.exceptions.ListsShouldBeEqualException;
import com.sparkit.staf.core.utils.SharedConstants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@StafLibrary(name = "Collections library", builtin = true)
public class CollectionsLibrary extends AbstractStafLibrary {

    @Keyword(name = "dictionaries should be equal", doc = "Verify if two dictionaries are equals")
    public void dictionariesShouldBeEqual(@KeywordArgument(name = "dict1") StafDictionary firstDict,
                                          @KeywordArgument(name = "dict2") StafDictionary secondDict) {
        compareMaps(firstDict.getObjectMap(), secondDict.getObjectMap());
    }

    @Keyword(name = "lists should be equal", doc = "Verify if two lists are equals")
    public void listsShouldBeEqual(@KeywordArgument(name = "list1") StafList firstList,
                                   @KeywordArgument(name = "list2") StafList secondList) {
        compareLists(firstList.getStafList(), secondList.getStafList());
    }

    @Keyword(name = "remove from list", doc = "Remove element from list at $index")
    public void removeListItem(@KeywordArgument(name = "list") StafList list,
                               @KeywordArgument(name = "index") StafInteger index) {
        list.getStafList().remove(index.getValue());
    }

    @Keyword(name = "remove from dictionary", doc = "Remove element from dictionary with $key")
    public void removeDictionaryItem(@KeywordArgument(name = "dict") StafDictionary dictionary,
                                     @KeywordArgument(name = "key") StafString key) {
        dictionary.removeItemAt(key.getValue());
    }

    @Keyword(name = "get dictionary keys", doc = "Get a list containing dictionary keys")
    public StafList getDictionaryKeys(@KeywordArgument(name = "dict") StafDictionary dictionary) {
        return new StafList(dictionary.getObjectMap().keySet().stream().map(StafString::new).collect(Collectors.toList()));
    }

    @Keyword(name = "get dictionary values", doc = "Get a list containing dictionary values")
    public StafList getDictionaryValues(@KeywordArgument(name = "dict") StafDictionary dictionary) {
        return new StafList(new ArrayList<>(dictionary.getObjectMap().values()));
    }


    @Keyword(name = "insert into list", doc = "Insert $element into list at $index")
    public void insertIntoList(@KeywordArgument(name = "list") StafList list,
                               @KeywordArgument(name = "index") StafInteger index,
                               @KeywordArgument(name = "element") AbstractStafObject objectToInsert) {
        list.getStafList().add((int) index.getValue(), objectToInsert);
    }

    @Keyword(name = "sort list", doc = "Sort $list with optional $reverse")
    public void sortList(@KeywordArgument(name = "list") StafList stafList, @KeywordArgument(name = "reverse", optional = true) StafBoolean reverse) {
        Comparator<AbstractStafObject> stafObjectComparator = Comparator.comparing((AbstractStafObject o) -> o.getValue().toString());
        if (reverse != null && (boolean) reverse.getValue()) {
            stafObjectComparator = stafObjectComparator.reversed();
        }
        stafList.getStafList().sort(stafObjectComparator);
    }


    private void compareMaps(Map<String, AbstractStafObject> firstMap, Map<String, AbstractStafObject> secondMap) {
        if (firstMap.size() != secondMap.size()) {
            throw new DictionariesShouldBeEqualException(SharedConstants.DICTIONARIES_SIZES_ARE_NOT_EQUALS);
        }
        for (Map.Entry<String, AbstractStafObject> firstMapEntry : firstMap.entrySet()) {
            if (!secondMap.containsKey(firstMapEntry.getKey())) {
                throw new DictionariesShouldBeEqualException("Second dictionary doesn't contain key [" + firstMapEntry.getKey() + "] : ");
            } else if (!firstMapEntry.getValue().getClass().equals(secondMap.get(firstMapEntry.getKey()).getClass())) {
                throw new DictionariesShouldBeEqualException("Objects types doesn't match with key [" + firstMapEntry.getKey() + "] : " + firstMapEntry.getValue() + " != " + secondMap.get(firstMapEntry.getKey()));
            } else if (firstMapEntry.getValue().isPrimitive() && !firstMapEntry.getValue().getValue().equals(secondMap.get(firstMapEntry.getKey()).getValue())) {
                throw new DictionariesShouldBeEqualException("Objects value doesn't match with key [" + firstMapEntry.getKey() + "] : " + firstMapEntry.getValue() + " != " + secondMap.get(firstMapEntry.getKey()));
            } else if (firstMapEntry.getValue() instanceof StafDictionary) {
                compareMaps(((StafDictionary) firstMapEntry.getValue()).getObjectMap(), ((StafDictionary) secondMap.get(firstMapEntry.getKey())).getObjectMap());
            } else if (firstMapEntry.getValue() instanceof StafList) {
                compareLists(((StafList) firstMapEntry.getValue()).getStafList(), ((StafList) secondMap.get(firstMapEntry.getKey())).getStafList());
            }
        }
    }

    private void compareLists(List<AbstractStafObject> firstList, List<AbstractStafObject> secondList) {
        if (firstList.size() != secondList.size()) {
            throw new DictionariesShouldBeEqualException(SharedConstants.LISTS_SIZES_ARE_NOT_EQUAL);
        }
        for (int i = 0; i < firstList.size(); i++) {
            AbstractStafObject firstListItem = firstList.get(i);
            AbstractStafObject secondListItem = secondList.get(i);
            if (!firstListItem.getClass().equals(secondListItem.getClass())) {
                throw new ListsShouldBeEqualException(SharedConstants.OBJECTS_TYPES_DOESNT_MATCH_AT_INDEX + "[" + i + "] : "
                        + firstListItem + " != " + secondListItem);
            } else if (firstListItem.isPrimitive() && !firstListItem.getValue().equals(secondListItem.getValue())) {
                throw new ListsShouldBeEqualException(SharedConstants.OBJECTS_VALUE_DOESNT_MATCH_AT_INDEX + i + "] : "
                        + firstListItem + " != " + secondListItem);
            } else if (firstListItem instanceof StafDictionary) {
                compareMaps(((StafDictionary) firstListItem).getObjectMap(), ((StafDictionary) secondListItem).getObjectMap());
            } else if (firstListItem instanceof StafList) {
                compareLists(((StafList) firstListItem).getStafList(), ((StafList) secondListItem).getStafList());
            }
        }
    }
}
