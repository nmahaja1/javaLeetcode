package com.practice;

//package com.codility;

// you can also use imports, for example:
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RestaurantFinder {

    public List<Integer> filterRestaurants(int[][] restaurants,
                                           int veganFriendly,
                                           int maxPrice,
                                           int maxDistance)
    {
        //create a list of list to get all restraunts data
        List<List<Integer>> listOfRestaurants =  new ArrayList<>();

        //Converting multi-dimensional array to List of List to use stream feature
        for(int i = 0; i < restaurants.length; i++){
            List<Integer> restaurantFields = Arrays.stream(restaurants[i])
                    .boxed().collect(Collectors.toList());

            listOfRestaurants.add(restaurantFields);
        }

        //fetch List of restaurant id which are vegan friendly, price and distance within range
        List<Integer> listOfRestaurantIds = listOfRestaurants.stream()
                .filter(l -> l.get(2) == veganFriendly
                && l.get(3) < maxPrice
                && l.get(4) < maxDistance)
                .sorted((l1,l2) -> {
                    //If ratings are equal sort based on restId
                    if(Integer.compare(l2.get(1), l1.get(1)) == 0){
                      return Integer.compare(l2.get(0), l1.get(0));
                    }else{
                        //Here rating is not same so return in desc order
                      return Integer.compare(l2.get(1), l1.get(1));
                    }
            })
                .map(l -> l.get(0))
                .collect(Collectors.toList());

        return listOfRestaurantIds;
    }

    public List<Integer> filterRestaurants2(int[][] restaurant1, int vegan, int price,
                                            int dist){

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<restaurant1.length; i++){
            int[] restaurant = restaurant1[i];
            int restId = restaurant[0];
            int rating = restaurant[1];
            int veganFriendly = restaurant[2];
            int price1 = restaurant[3];
            int distance = restaurant[4];

            if(veganFriendly == vegan && price1 <= price && distance <= dist){
                result.add(restId);
            }
        }
        result.sort(Comparator.comparing((Integer restId) -> restaurant1[restId - 1][1]).reversed());

        //result.sort(Comparator.comparing(restId -> restaurant1[restId - 1][1]).reversed());

        return result;
    }

    public static void main(String [] args) {

        int[][] restaurants = {{1,4,1,40,10},
                {2,8,0,50,5},
                {3,8,1,30,4},
                {4,10,0,10,3},
                {5,7,1,15,9}};
        int veganFriendly = 1;
        int maxPrice = 50;
        int maxDistance = 10;

        RestaurantFinder mn = new RestaurantFinder();

        List<Integer> result =
                mn.filterRestaurants2(restaurants, veganFriendly, maxPrice, maxDistance);

        System.out.println(result);

    }
}
