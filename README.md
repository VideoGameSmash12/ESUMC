# ESUMC
[The EssentialsX developers overhauled how user maps are handled and stored in versions 2.20.0 and newer.](https://hangar.papermc.io/EssentialsX/Essentials/versions/2.20.0#usermap-storage-and-cache-changes) To make it easier to upgrade from 2.19.x and older, they made it so that it builds the user cache using entries in the `userdata` folder instead of an existing usermap.csv file. This ended up causing problems with certain configurations and as a result, some entries were just outright missing from the generated user map despite userdata actually existing.

This was my solution: a standalone application that reads entries from `usermap.csv` and simply spits the information out in the new format.

## Usage
Follow these steps:
1. Put the `usermap.csv` file from Essentials into the same folder as the JAR.
2. Run it as if it was a standard Java application:
```none
java -jar ESUMC-1.0-SNAPSHOT.jar
```
