import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration.component';

describe('RegistrationComponent', () => {
  let component: RegistrationComponent;
  let fixture: ComponentFixture<RegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RegistrationComponent],
      imports: [FormsModule]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should register user when passwords match', () => {
    component.password = 'password';
    component.confirmPassword = 'password';
    spyOn(window, 'alert');

    component.register();

    expect(window.alert).toHaveBeenCalledWith('User registered successfully!');
  });

  it('should handle password mismatch', () => {
    component.password = 'password';
    component.confirmPassword = 'different-password';
    spyOn(window, 'alert');

    component.register();

    expect(window.alert).toHaveBeenCalledWith('Password and confirmation do not match!');
  });
});
