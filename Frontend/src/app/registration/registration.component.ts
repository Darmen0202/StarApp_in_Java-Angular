import { Component } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  username: string ='';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  register() {
    if (this.password === this.confirmPassword) {
      // Пароль совпадает с подтверждением, выполнить регистрацию пользователя
    } else {
      // Обработать ошибку несовпадения пароля и подтверждения
    }
  }
}
