import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  // styleUrls: ['./home.component.css']
})
export class HomeComponent {
  stars: Star[] = []; // Массив звезд

  starClasses: string[] = ['голубая', 'бело-голубая', 'белая', 'желто-белая', 'желтая', 'оранжевая', 'красная']; // Массив классов звезд

  discoverers: string[] = ['Открыватель 1', 'Открыватель 2', 'Открыватель 3']; // Массив открывателей звезд

  star: Star = {
    name: '',
    coordinates: '',
    class: '',
    discoveredBy: ''
  };

  showModal: boolean = false; // Флаг отображения модального окна
  formTitle: string = ''; // Заголовок модального окна
  submitButtonText: string = ''; // Текст кнопки сохранения

  addStar() {
    this.formTitle = 'Добавить звезду';
    this.submitButtonText = 'Добавить';
    this.star = {
      name: '',
      coordinates: '',
      class: '',
      discoveredBy: ''
    };
    this.showModal = true;
  }

  editStar() {
    this.formTitle = 'Изменить звезду';
    this.submitButtonText = 'Сохранить';
    // Логика выбора звезды для редактирования
    this.showModal = true;
  }

  deleteStar() {
    // Логика удаления звезды
  }

  saveStar() {
    if (this.formTitle === 'Добавить звезду') {
      // Логика добавления звезды
    } else {
      // Логика сохранения изменений звезды
    }
    this.showModal = false;
  }
}

interface Star {
  name: string;
  coordinates: string;
  class: string;
  discoveredBy: string;
}
