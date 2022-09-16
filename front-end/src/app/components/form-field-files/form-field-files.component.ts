import { Component, OnInit, Input } from '@angular/core';
import { FileUploader, FileItem, FileSelectDirective } from 'ng2-file-upload';
import { DataSource } from '@angular/cdk/table';
import { MatTable, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'nsc-form-field-files',
  templateUrl: './form-field-files.component.html',
  styleUrls: ['./form-field-files.component.scss']
})
export class FormFieldFilesComponent implements OnInit {
  public uploader: FileUploader;
  public dataSource: MatTableDataSource<FileItem>;
  public columnsToDisplay = ['itemName', 'itemSize', 'itemStatus', 'itemButtons'];
  private reg = /^((?![.]{2})[a-zA-Z0-9 _.-]){1,}$/;
  @Input() url: string;
  @Input() allowedFileTypes: string[];
  @Input() maxFileCount: number;
  constructor() { }

  ngOnInit() {
    this.uploader = new FileUploader({url: this.url});
    this.dataSource = new MatTableDataSource<FileItem>();
  }

  updateDataSource() {
    this.dataSource.data = this.uploader.queue;
  }


  // Pass the 'select files' button click to the file input element
  fileInputClick() {
    const fileinput: HTMLElement = document.getElementById('input-files');
    fileinput.click();
  }


  // event triggered when a new file is selected from the file input
  onFileSelected(files) {
    console.log('onFileSelected', files);
    Array.from(files).forEach(function(file: File, index: number) {

    });
    this.updateDataSource();
  }


  // button click events
  uploadAllClick() {
    console.log('uploadAllClick', this.uploader);
    // Double-check that all file parameters are valid
    let validUpload = true;
    for (let i = 0; i < this.uploader.queue.length; i++) {
      const item = this.uploader.queue[i];
      const filenameArr = item.file.name.split('.'); // split filename into array
      const ext = filenameArr.pop(); // keep last element as the file extension
      // Check filename against regex
      if (!this.reg.test(item.file.name)) {
        validUpload = false;
        window.alert('The document does not meet the file naming conventions. File names may only contain alpha numeric characters, periods, dashes, underscore and spaces. Please ensure your document meets this requirement and try again.');
        break;
      }
      // Check filename length
      if (item.file.name.length > 64) {
        validUpload = false;
        window.alert('The file name cannot exceed 64 characters. Please rename the file and try again.');
        break;
      }
      // Check the extension
      if ((filenameArr.length > 1) && (this.allowedFileTypes.indexOf(ext.toLowerCase()) > -1)) {
        validUpload = false;
        window.alert('The document you are trying to upload does not meet the requirements, it is the wrong file type. Please ensure your document meets this requirement and try again.');
        break;
      }
      // Check the file size
      if (item.file.size > (5000000)) {
        validUpload = false;
        window.alert('The document you are trying to upload does not meet the requirements, it is larger than 5 MB. Please ensure your document meets this requirement and try again.');
        break;
      }
    }
    if (validUpload) {
      this.uploader.uploadAll();
    }
  }
  cancelAllClick() {
    console.log('cancelAllClick', this.uploader);
    this.uploader.cancelAll();
  }
  removeAllClick() {
    console.log('removeAllClick', this.uploader);
    const remove = window.confirm('Are you sure you want to remove the files?');
    if (remove) {
      this.uploader.clearQueue();
      this.updateDataSource();
    }
  }
  removeFileClick(item: FileItem) {
    console.log(item.file.name);
    const remove = window.confirm('Are you sure you want to remove the file?');
    if (remove) {
      item.remove();
      this.updateDataSource();
    }
  }
  retryFileClick(item: FileItem) {
    console.log(item);
    item.upload();
  }


  // Simple utility methods to format the file byte size
  roundFileSizeValue(val: number): string {
    let size = val;
    let suffix = ' bytes';
    // This could be something more elegant, but I don't
    // need to account for anything bigger than megabytes
    if (size > 1000) {
      size = this.byteRounding(size);
      suffix = ' kB';
    }
    if (size > 1000) {
      size = this.byteRounding(size);
      suffix = ' MB';
    }
    return size + suffix;
  }
  byteRounding(val: number): number {
    return Math.round( (val / 1000.0) * 10 ) / 10;
  }
}
