import { Component } from '@angular/core';
import { RegisterService } from '../../services/register.service';
import { CsrfService } from '../../services/csrf.service';

@Component({
  selector: 'app-registration',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  constructor(
    private registerService: RegisterService,
    private csrfService: CsrfService
  ) {}

  register() {
    if (this.password !== this.confirmPassword) {
      // Выполнить действие при неправильном подтверждении пароля, например, показать сообщение об ошибке
      return;
    }

    this.csrfService.getCsrfToken().subscribe((csrfToken: string) => {
      const registerData = {
        username: this.username,
        email: this.email,
        password: this.password,
        csrfToken: csrfToken
      };

      this.registerService.register(registerData).subscribe(
        (response) => {
          console.log('Регистрация прошла успешно:', response);
        },
        (error) => {
          console.error('Ошибка при регистрации:', error);
        }
      );
    });
  }
}
