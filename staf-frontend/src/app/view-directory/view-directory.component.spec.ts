import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDirectoryComponent } from './view-directory.component';

describe('ViewDirectoryComponent', () => {
  let component: ViewDirectoryComponent;
  let fixture: ComponentFixture<ViewDirectoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDirectoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDirectoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
