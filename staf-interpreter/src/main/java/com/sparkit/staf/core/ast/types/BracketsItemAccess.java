package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.utils.SharedConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BracketsItemAccess extends AbstractStafObject {
    private static final Logger logger = LoggerFactory.getLogger(BracketsItemAccess.class);
    private final AbstractStafObject parentObjectReference;
    private final AbstractStafObject indexObject;

    public BracketsItemAccess(AbstractStafObject stafListReference, AbstractStafObject indexObject) {
        this.parentObjectReference = stafListReference;
        this.indexObject = indexObject;
        this.type = StafTypes.BRACKETS_ITEM_ACCESS;
    }

    @Override
    public AbstractStafObject evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        AbstractStafObject objectReferenceValue = parentObjectReference;
        if (!(parentObjectReference instanceof StafList || parentObjectReference instanceof StafDictionary)) {
            objectReferenceValue = (AbstractStafObject) parentObjectReference.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        }
        if (objectReferenceValue instanceof StafList) {
            StafList stafList = (StafList) objectReferenceValue.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
            AbstractStafObject actualIndexObject = (AbstractStafObject) indexObject.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
            if ((Integer) actualIndexObject.getValue() >= stafList.getStafList().size()) {
                logger.error(SharedConstants.LIST_INDEX_OUT_OD_BOUNDS, actualIndexObject);
                throw new IndexOutOfBoundsException();
            }
            return stafList.getStafList().get((Integer) actualIndexObject.getValue());
        } else if (objectReferenceValue instanceof StafDictionary) {
            StafDictionary stafDictionary = (StafDictionary) objectReferenceValue.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
            AbstractStafObject actualKeyObject = (AbstractStafObject) indexObject.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
            AbstractStafObject evaluatedStafObject = stafDictionary.getObjectMap().get(actualKeyObject.getValue());
            if (evaluatedStafObject == null) {
                logger.error(SharedConstants.DICTIONARY_DOESNT_CONTAIN_KEY, actualKeyObject);
            }
            return evaluatedStafObject;
        }
        return null;
    }
}
