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
