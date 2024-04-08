1. ## Nowy projekt maven
- IdeasApplication w odpowiednim pakiecie
- Klasy - model - Category, Question, Answer
    - konstruktory
    - relacje miedzy nimi
- Pseudokod głównej logiki

2. ## Główna pętla programu oraz komunikacja z użytkownikiem
- Główna pętla programu (zmienna sterująca i obsługa wyjątków)
- UserInputManager, UserInputCommand - szkic
- Implementacja UserInputManager
- Implementacja UserInputCommand

3. ## Testy aplikacji i TDD
- Dodanie JUnit5 do projektu
- Wygenerowanie testu dla UserInputCommand

4. ## Implementacja obsługi komend
- Pusta list commandHandlerów
- Interfejs CommandHand-er
- BaseCommandHandler
- HelpCommandHandler
- QuiteCommandHandler
- Dodanie handlerów do listy i obsługa listy:
  a) optional
  b) log nieznany command handler
  c) break głównej pętli

5. ## Komunikacja z systemem plików oraz utrwalenie danych
- CategoryCommandHandler - szablon
- Zapis do pliku, komunikacja z DAO, CategoryDao
- Wypełnienie CategoryCommandHandler
- Category.toString

6. ## Serializacia obiektów
- Copy CategoryDao to QuestionDao-> problem z serializacją
  - zależność jackson-databind
  - Refaktor QuestionDao z jackson

7. ## Refaktoryzacia kodu
- Wprowadzenie enum Action
  - Refaktor o wprowadzeniu UserInputCommand.action
- QuestionCommandHandler
  - dodanie CategoryDao i pobranie kategorii
  - metoda CategoryDao.findOne
  - refaktor CategoryDao na jackson
  - Model.Question - default konstruktor la jackson

8. ### Logi, obsługa wyjątków oraz walidacja danych
- dodajemy Loggery: do wszystkich klas
- AnswerCommandHandler kopia z question
  - questionDao.findOne
  - questionDao.addAnswer
- walidacja parametrów
  - spróbować wprowadzić niepoprawne dane
  - CategoryCommandHandler walidacja parametrów
  - główna pętla dodatkowy catch na walidacje
