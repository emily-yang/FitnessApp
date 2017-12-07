package edu.csulb.android.fitnessapp;

/**
 * Created by joannato on 12/6/17.
 */

public class EventCategory {

        private String name;
        private int photo;

        public EventCategory (String cName, int cPhoto){

            this.name = cName;
            this.photo = cPhoto;

        }

        public String getCategoryName() {
            return name;
        }

        public int getPhoto()
        {
            return photo;
        }
    }


