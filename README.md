# Poligon dla projektu R***r

## Model Post

Post posiada poziom, wstępnie ustalany przy tworzeniu.

Post ma mieć możliwość zmiany swojego poziomu na podstawie oddanych głosów na każdy z możliwych poziomów (o finalnym poziomie decyduje max z ilości głosów na każdy poziom).

Opcji realizacji jest dużo (tutaj przyjęto #3):
1. Post ma tylko aktualizowaną informację o swoim poziomie, istnieje coś (usługa, funkcja) która wylicza finalny poziom na podstawie oddanych głosów
2. Post przechowuje głosy (ew. samą ilość) i sam wylicza poziom i przechowuje aktualny w polu @Transient
3. Post deleguje zarządzanie do dedykowanej klasy "Level" .
4. Inne pomysły?
 
Oprócz biznesowych aspektów przy modelowaniu rozwiązania trzeba wziąć pod uwagę reprezentację modelu w bazie.

### Model PostLevelScore

Tutaj przyjęto, że encja "Level" będzie miała trzy pola dla reprezentowania ilości oddanych głosów na każdy poziom. Oddzielnie może istnieć tabela która przechowuje każdy głos, ale nie chcemy ich zliczać każdorazowo, stąd przechowamy sumaryczne wartości. Finalny poziom będzie wyliczany.

Klasa umożliwi zwrócenie aktualnego poziomu, oraz umożliwi doliczenie głosu na jeden z poziomów.
Zdefiniowane są trzy liczniki dla poziomów JUNIOR, MID, SENIOR. 

Funkcja wyliczająca poziom zwraca nazwę poziomu o największej ilości głosów, w przypadku wielu poziomów z tym samym głosem, zwróci je wg najwyższej kolejności: SENIOR, MID, JUNIOR.



