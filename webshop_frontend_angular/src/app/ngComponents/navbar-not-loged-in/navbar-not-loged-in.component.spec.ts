import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarNotLogedInComponent } from './navbar-not-loged-in.component';

describe('NavbarNotLogedInComponent', () => {
  let component: NavbarNotLogedInComponent;
  let fixture: ComponentFixture<NavbarNotLogedInComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavbarNotLogedInComponent]
    });
    fixture = TestBed.createComponent(NavbarNotLogedInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
