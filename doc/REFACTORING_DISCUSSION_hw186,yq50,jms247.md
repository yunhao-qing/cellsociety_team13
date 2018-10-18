Refactoring discussion
----------------------
Refactoring lab discussion on September 27
Haotian Wang hw186
Yunhao Qing yh50
Julia Saveliff jms247

Duplication Refactoring
-----------------------
* Merge getNeighbors into a new method in the superclass such that it can take an array of index and outputs the neighbors corresponding to the input array.

Checklist Refactoring
---------------------
* Added a USER_PANEL_ITEM_SPACING to replace the magic value that represents the spacing between user panel children.
* Bring multiple statements in one line to several lines.
* In Rule, replace the type specification in this constructor call with the diamond operator ("<>").
* Import specific classes instead of wild card generals.
* Remove nested conditionals in WatorRule.
* In Grid, remove this unused "myRoot" private field.
* Remove unused import.

Longest Method Refactoring
--------------------------
* In RuleOfLife, break determineNextStates to smaller methods.
* In SpreadingOfFire, break down determineNextStates to smaller methods.
* In WatorRule, break down determineNextStates to smaller methods.