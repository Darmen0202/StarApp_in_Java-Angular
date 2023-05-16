# template-java-project
[![Статус строения](https://img.shields.io/travis/com/pascalpoizat/template-java-project/master.svg?style=flat-square)](https://travis-ci.com/github/pascalpoizat/template-java-project)
[![Покрытие кода с помощью тестов ](https://img.shields.io/coveralls/pascalpoizat/template-java-project/master.svg?label=coverage%20with%20coveralls&style=flat-square)](https://coveralls.io/github/pascalpoizat/template-java-project)
[![Тэги](https://img.shields.io/github/tag/pascalpoizat/template-java-project.svg?label=tag&style=flat-square)](build.gradle)
[![Версия](https://img.shields.io/github/release/pascalpoizat/template-java-project.svg?style=flat-square)](build.gradle)
[![Дата создания](https://img.shields.io/github/release/pascalpoizat/template-java-project/all.svg?label=(pre-)release&style=flat-square)](build.gradle)
<br/>

[![Технический ссылки](https://sonarcloud.io/api/project_badges/measure?project=fr.parisnanterre.pascalpoizat%3Atemplate-java-project&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=fr.parisnanterre.pascalpoizat%3Atemplate-java-project)

Java-проект + Angular с открытым исходным кодом

Это используется в качестве для создания записи звезд.
## dependencies

Все следующие используемые файлы бесплатны.

- Репозиторий исходных текстов и виртуальные машины

  Мы будем использовать [GitHub](https://github.com /).
    Конечно, вы можете использовать здесь другой VCS.
    Что приятно в GitHub, так это интеграция с CI, управлением проблемами и советами по проектам (смотрите ниже).
    Итак, здесь вам нужно только создать репозиторий.

    Вы должны подписать свою работу (коммиты и теги). Смотрите [здесь](https://git-scm.com/book/en/v2/Git-Tools-Signing-Your-Work ).
    
    Структурированные сообщения о фиксации помогают понять изменения и выполнять автоматизированные задачи, такие как создание журналов изменений.
    Мы предлагаем следовать [рекомендациям по фиксации Angular JS](https://github.com/angular/angular.js/blob/master/CONTRIBUTING.md#commit )
    (смотрите также [вариант, приведенный здесь](https://karma-runner.github.io/1.0/dev/git-commit-msg.html )). 

    Чтобы легко следовать этим рекомендациям (в обычном формате), вы можете:
    
    - установите и используйте [утилиту командной строки commitizen](http://commitizen.github.io/cz-cli /),
      *например*, используйте `git cz` вместо `git commit -m "..."` или используйте плагин для вашей IDE (*например*, смотрите [здесь](https://github.com/KnisterPeter/vscode-commitizen )). Адаптер, который мы используем, называется "cz-conventional-changelog`.
      
    - установите и используйте [утилиту командной строки clog](https://github.com/clog-tool/clog-cli ) для создания журналов изменений
       из сообщений о фиксации, которые соответствуют общепринятому формату.
       
    Если вы используете для работы с несколькими проектами одновременно,
вы можете рассмотреть возможность использования [незафиксированного](https://pypi.python.org/pypi/uncommitted ) команда.

- Проблемы
 
    Мы будем использовать Github для решения проблем.
    Смотрите [здесь](https://guides.github.com/features/issues /) для получения документации по вопросам Github.
    
    Мы будем использовать схему, предложенную [Посредственным Laboratories](https://mediocre.com/forum/topics/how-we-use-labels-on-github-issues-at-mediocre-laboratories ) для наклеек:
    
    - приоритет: высокий (#b60205),
приоритет: средний (#fbca04),
приоритет: низкий (#0e8a16)
    	
    - тип: ошибка (#e99695),
тип: технический долг (#fef2c0),
тип: особенность (#c2e0c6)
    	
    - другие метки, включая "дубликат", "не исправлено", "недопустимо", "готово" и "выполняется", начинаются с ~, например,
~ready (#ededed)

    Смотрите [здесь](https://github.com/pascalpoizat/template-java-project/labels ) для получения списка меток.
    
    Чтобы следить за вашими проблемами (и работой над ними), вы можете использовать один из:
    
    - [Проект на Github Boards](https://docs.github.com/en/free-pro-team@latest/github/managing-your-work-on-github/about-project-boards)
    - [Доски GitKraken](https://www.gitkraken.com/boards ) и смотрите [здесь](https://github.com/marketplace/gitkraken-glo-boards ) для интеграции между досками GitKraken и GitHub
һ

- Тестовое покрытие

    Мы будем использовать [testNG](http://eclemma.org/testNG /) для составления отчетов о тестовом покрытии.
    В настоящее время он не поддерживает исключение частных конструкторов из анализа.
    Следовательно, вы не получите 100%-ного охвата в отчетах, если будете их использовать
    (в любом случае, помните, что 100%-ный охват сам по себе не является целью).
    Чтобы иметь поддержку testNG, ничего не нужно делать, предоставленные файлы ``.travis.yml`` и ``build.gradle`` выполнят эту работу.

- Теги и релизы





    - Первый запуск: ![ТЕГ](Мы будем использовать для запуска джава приложения SpringBoot)

	    <pre>
	    
	    </pre>

    - ng serve

	    <pre>
	    ng server
	    </pre>


- Документация

  Мы будем использовать [Angular](https://angular.org) и [Java](https://java.org)
