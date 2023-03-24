# Problem 1: EU Cities Temperatures Dataset 
## Given a CSV data file as represented by the sample file EuCitiesTemperatures.csv Download EuCitiesTemperatures.csv (213 records), load it into a Pandas DataFrame and perform the following tasks on it.

Visualization (27 pts)
For all plots, make sure to label the axes, and set appropriate tick labels.

[6 pts] Plot a bar chart for the number of cities belonging to each of the regions described in Preprocessing/Analysis #3 above.
[7 pts] Plot a scatter plot of latitude (y-axis) v/s longitude (x-axis) values to get a map-like visual of the cities under consideration. All the cities in the same country should have the same color.
[6 pts] The population column contains values unique to each country. So two cities of the same country will show the same population value. Plot a histogram of the number of countries belonging to each population group: split the population values into 5 bins (groups).
[8 pts] Plot subplots (2, 2), with proper titles, one each for the region types described in Preprocessing/Analysis #3 above.
Each subplot should be a scatter plot of Latitude (y-axis) vs. City (x-axis), where the color of the plot points should be based on the temperature values: ‘red’ for temperatures above 10, ‘blue’ for temperatures below 6 and ‘orange for temperatures between 6 and 10 (both inclusive). For each subplot, set xticks to an array of numbers from 0 to n-1 (both inclusive), where n is the total number of cities in each region type. This represents each city as a number between 0 and n-1.

# Problem 2: German Credit Dataset 
## Given a CSV data file as represented by the sample file GermanCredit.csv Download GermanCredit.csv (1000 records), load it into a Pandas DataFrame, and perform the following tasks on it.

Important: Your code should be applicable to any extension of this sample, so make sure you don't hardcode anything that applies only to the values in this sample.

Visualization (24 pts)
 

[9 pts] Plot subplots of two histograms: one with savings_status on the x-axis and personal_status as different colors, and another with checking_status on the x-axis and personal_status as different colors.
[9 pts] For people having credit_amount more than 4000, plot a bar graph which maps property_magnitude (x-axis) to the average customer age for that magnitude (y-axis).
[6 pts] For people with a "High" savings_status and age above 40, use subplots to plot the following pie charts:
Personal status
Credit history
Job

# Problem 3: Google Playstore Apps Dataset 
## Given an Excel data file as represented by the sample file GooglePlaystore.xlsx Download GooglePlaystore.xlsx (10K records), load it into a Pandas DataFrame (use the Pandas read_excel method), and perform the following tasks on it.

Important: Your code should be applicable to any extension of this sample, so make sure you don't hardcode anything that applies only to the values in this sample.
 

Visualization (16 pts)
[9 pts] In the genre column, break the string of genres into a list. For example, ‘Art & Design; Creativity’ should be [‘Art & Design’, Creativity’].
Count the number of applications per genre and display it using a pie chart.
Hint: Read about DataFrame.explode()

[7 pts] Display a box plot of ratings for "Business" and "Education" categories. The boxplots should be in the same plot.
