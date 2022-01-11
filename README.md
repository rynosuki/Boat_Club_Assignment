# Boatclub application

There are some limitations as to having enough letters in a name or using only numbers in creating a boat length.

# Group members
Robin Svensson (rs223dj)  
Mattias Stålgren (ms225kw)  
Emma Lövgren (el222wg)  


# Usage
The program is mainly used by moving through the different menus, currently being two. One for members and one for boats.  
These are easily transversable and usable. Everything should be straight forward to use by just following the wording in the application. 

**Selections for Member Menu:**
1. Add member
2. Delete member
3. Change member
4. View member details
5. Show verbose list
6. Show compact list


**Selections for Boat Menu:**  
Step 1: Choose a member to add/remove/change a boat for.  

Step 2: Choose from menu.
1. Add Boat
2. Remove Boat      
3. Change Boat      
4. Back to menu   

## Second language
To be able to switch language you need to comment and uncomment the code under the comment "English view" or "Swedish view" in the controller classes (App, BoatController, MemberController)

### English
- Classes: BoatView, MainView and MemberView
- Uses numbers as input
- Sorted by name

### English
- Classes: BoatViewSwedish, MainViewSwedish and MemberViewSwedish
- Uses characters as input
- Sorted by member ID

