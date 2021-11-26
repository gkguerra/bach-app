# BachApp

## A reality TV fantasy football application!

*The Bachelorette is a reality tv dating show in which 30 eligible male bachelors compete to find love with a chosen 
bachelorette. Each week, the bachelorette goes on dates with the bachelors and eliminates those she does not have a 
connection with through a rose ceremony. Men progressing to the next week of the show get a rose, men who do not get a 
rose are sent home. This continues until two men remain, and the bachelorette accepts a marriage proposal from one of 
them. There is romance, drama, love, and lots of laughs!*

**What will the application do?**
- This application will track the statistics of each bachelor as they compete for love (number of dates, 
number of roses received, etc.)
- This application will allow users to create a "cast" of no more than three bachelors, and the users can monitor the 
progress of their "cast" throughout the season.
- Cast members will become "set" at a certain point throughout the season.
- This application will calculate a score for each bachelor (based on how many roses and dates they have received).

**Who will use it?**
- The viewers of the Bachelorette (also known as Bachelor Nation). 
    - For reference, 6.07 million people watched the Bachelor finale in 2021 according to The Hollywood Reporter. 
    - https://www.hollywoodreporter.com/tv/tv-news/tv-ratings-monday-march-15-2021-4151388/

**Why is this project of interest to you?**
- I think other viewers of the Bachelorette could actually enjoy using this application!
- I have spent more time than I care to admit watching this show and I figure I should put my knowledge of it
to good use while developing this application :)


## User Stories:

- As a user, I want to be able to view all the contestants in the game.
- As a user, I want to be able to view the contestants on my cast.
- As a user, I want to be able to add contestants to my cast.
- As a user, I want to be able to remove contestants from my cast.
- As a user, I want to be able to quit the game.
- As a user, I want to be prompted to save my cast to file when I quit.
- As a user, I want to be able to load my cast from file.

## Phase 4: Task 2

- Sample output:

Tue Nov 23 16:39:55 PST 2021
Contestant added: Brandon

Tue Nov 23 16:39:58 PST 2021
Contestant added: Bryan

Tue Nov 23 16:40:01 PST 2021
Contestant removed: Bryan

Tue Nov 23 16:40:05 PST 2021
Contestant added: Chris

## Phase 4: Task 3

If I had more time to work on this application, I would:

- Make separate classes for each button and the action listener for each button 
to reduce the coupling of the code in BachGameJFrame
- Use the Singleton design pattern to ensure that each user only has one Cast
- Eliminate the "id" field from the Cast class, it's useless
- Abstract out the log-in and sign-in methods to reduce repeated code