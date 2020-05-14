import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'itemType'
})
export class ItemTypePipe implements PipeTransform {

  transform(type: string): string {
    if (type == 'scroll') {
      return 'File';
    }
    return 'Folder';
  }

}
