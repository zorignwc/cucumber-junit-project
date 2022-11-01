package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//This class is only 1 time we are creating in utilities package

public class ConfigurationReader {

    //We need to Create the object of properties class
    // we need properties class to use methods coming from getProperty("key")
    //It is static because we using it in static method and static block
    // It is private because I will be using only in this class
    private static Properties properties = new Properties();

//We want to open the properties file and load to properties object ONLY ONCE before reading
    //Having static block because static runs first
    static{


        try{

            //2 create the object of FileInputStream
            //we need this object to open file as a stream in java memory
            FileInputStream file = new FileInputStream("configuration.properties");

            //3 load the properties object using FileInputStream object
            //Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);
        // Close the file after loading
        // if we do not close the file, it will take space from computer memory like Scanner
        file.close();

        }catch(IOException e){
            e.printStackTrace();

    }
}

    /**
     * This method is used to read value from configuration.properties file
     *
     * @param keyword --> key name in configuration.properties file
     * @return ---> value for the key. return null if key is not found
     * driver.get(ConfigurationReader.getProperty("env"))
     */

public static String getProperty(String keyword){
        return properties.getProperty(keyword);

}






    }





