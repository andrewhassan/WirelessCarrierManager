Wireless Carrier Manager
========================

# Problem #
We have a bunch of SIM cards on a bunch of different data plans for different carriers. Obviously, some plans may be better suited than others for different users' usages. However, we have no way of predetermining the usage of a user so we can't tell if they'll need more or less data than the plan they're currently using. In order to fix this, we want to monitor the usage (as frequently as possible) to determine whether they'll be overusing or underusing the plan at the end of the month.

## More Detail About the Problem ##
To solve this problem more easily, it is important to classify it so that we can incorporate existing solutions into our own. At first glance, this problem appears to be something like the "knapsack problem". But trying to project this onto the knapsack problem doesn't quite work.

# Solution #
The solution to this problem is interesting: Essentially, what we have to do is systematically look at all the SIM cards and their plans. Then decide whether it is worth it to switch the SIM cards in the middle of the month, taking into account switching fees, overage fees, etc. To make things a bit more complicated, we have the ability to group SIM cards into groups of plans, which basically gives the whole pool a lumpsum of data. For certain pools, there may or may not be a penalty to switching SIM cards.

This problem will be solved by using the APIs supplied by carriers to retrieve usage data for all the SIM cards. Once the data has been retrieved, an analytics service will look at the usage for each SIM card to determine whether it should inspect plan options for the card. The best options for switching SIM cards will be suggested to the user, along with data plots, through a web application interface.

# How to Get it Working #

## Get your environment set up ##
1. Download and install a JDK

	> **Note:** This application is being developed with *Oracle JDK 1.7*.
2. Download the [*Play Framework*](http://www.playframework.com/)
	> **Note:** If you're on Mac, you can install the latest Play Framework by installing homebrew and running the command `brew install play`. You can then skip this step.

	> **Another note:** The framework version matters. The version that this application is developed with is **2.1.2**. For use with another version, you will have to [upgrade the project](http://www.playframework.com/documentation/2.1.x/Migration).
3. Copy the Play Framework to a directory that you have read/write access to.
4. Add the Play Framework directory to your path.

## Compile and run the application ##

1. Pull the source code from github.
2. Open a terminal or command prompt and go to the source directory.
	> Make sure you're in /WirelessCarrierManager/WirelessCarrierManager and that you see a bunch of folders (app, conf, logs, etc.).
3. Type in `play`. This opens up the Play terminal for the application. When it first starts up, it will automatically download dependencies.
4. From here, you can type commands such as `compile`, `run`, or `debug`.
	> When you use `run`, Play will automatically compile any changed source files when the code is hit.

> **Note:** You want to make sure that you have a MySQL database running and that you have a `wireless_carrier` schema set up. Don't worry about creating tables, Evolution will take care of that for you.

## Set Up an IDE ##

Both *Eclipse* and *IntelliJ IDEA Ultimate* have support for the Play Framework. There are probably other ones as well, but these are the two that I tested. I have already generated Eclipse and IntelliJ files for the project so it should technically work out of the box.

# Technical Stuff #
## Stuff that was used in this project: ##
- Play! Framework
- JDBC MySQL Driver
- EBean
- Evolution
- CoffeeScript