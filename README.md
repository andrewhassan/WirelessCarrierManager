Wireless Carrier Manager
========================

# Problem #
We have a bunch of SIM cards on a bunch of different data plans for different carriers. Obviously, some plans may be better suited than others for different users' usages. However, we have no way of predetermining the usage of a user so we can't tell if they'll need more or less data than the plan they're currently using. In order to fix this, we want to monitor the usage (as frequently as possible) to determine whether they'll be overusing or underusing the plan at the end of the month.

# Solution #
The solution to this problem is interesting: Essentially, what we have to do is systematically look at all the SIM cards and their plans. Then decide whether it is worth it to switch the SIM cards in the middle of the month, taking into account switching fees, overage fees, etc. To make things a bit more complicated, we have the ability to group SIM cards into groups of plans, which basically gives the whole pool a lumpsum of data. For certain pools, there may or may not be a penalty to switching SIM cards.

This problem will be solved by using the APIs supplied by carriers to retrieve usage data for all the SIM cards. Once the data has been retrieved, an analytics service will look at the usage for each SIM card to determine whether it should inspect plan options for the card. The best options for switching SIM cards will be suggested to the user, along with data plots, through a web application interface.

# More Detail About the Problem #
To solve this problem more easily, it is important to classify it so that we can incorporate existing solutions into our own. At first glance, this problem appears to be something like the "knapsack problem". 
