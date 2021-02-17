package com.himashi.algorithm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
public class PhotoProblem {
    public String solution(String S) {
        List<Photo> photos =new ArrayList<>();
//        Set<String> citySet=new HashSet<>();

        // split given photo details string
        String[] photoArray = S.split("\n");

        // loop through the photo array
        for (int i = 0; i < photoArray.length; i++) {
            String[] photoDataArray = photoArray[i].split(",");
            // create a new Photo instance
            Photo photo =new Photo(i, photoDataArray[0].split("\\.")[0], photoDataArray[1], convertStringToDate(photoDataArray[2]), photoDataArray[0].split("\\.")[1]);
            // add photo city to the citySet
//            citySet.add(photoDataArray[1]);
            // add created photo to the photos list
            photos.add(photo);
        }

        final Map<String, List<Photo>> photoMap = photos.stream().sorted(Comparator.comparing(Photo::getPhotoDate)).collect(Collectors.groupingBy(Photo::getPhotoCity));

        // create a new copy from photos list
//        List<Photo> photosCopy=List.copyOf(photos);

        //clear current photos from photos list since we need to add the groped and sorted photos to the same list
        photos.clear();
        photoMap.values().forEach(photoList->{
            // set the photo number for all the photos by loop through the grouped photos and add to the original photos list
            for (int i = 0; i < photoList.size(); i++) {
                String format = String.format("%0"+(int)(Math.log10(photoList.size())+1)+"d", i+1);
                Photo photo = photoList.get(i);
                photo.setPhotoNumber(format);
                photos.add(photo);
            }
        });
//        for (String city:citySet) {
//            // groped and sort the copy of the photos
//            List<Photo> cityGrouped = photosCopy.stream()
//                    .filter(p -> p.getPhotoCity()
//                            .equalsIgnoreCase(city))
//                    .sorted(Comparator.comparing(Photo::getPhotoDate)).collect(Collectors.toList());
//
//
//            // set the photo number for all the photos by loop through the grouped photos and add to the original photos list
//            for (int i = 0; i < cityGrouped.size(); i++) {
//                String format = String.format("%0"+(int)(Math.log10(cityGrouped.size())+1)+"d", i+1);
//                Photo photo = cityGrouped.get(i);
//                photo.setPhotoNumber(format);
//                photos.add(photo);
//            }
//
//        }

        //sort the photos to the id
        Collections.sort(photos, Comparator.comparingInt(Photo::getId));

        // build the new photo details string and return
        StringBuilder stringBuilder=new StringBuilder();
        for (Photo photo:photos) {
            stringBuilder.append(photo.toString());
            stringBuilder.append("\n");
        }
        return  stringBuilder.toString();
    }

    public Date convertStringToDate(String dateString){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    // photo class for hold the photo data
    public class Photo {

        int id;
        String photoName;
        String photoCity;
        Date photoDate;
        String photoNumber;
        String extension;

        public Photo(int id, String photoName, String photoCity, Date photoDate, String extension) {
            this.id = id;
            this.photoName = photoName;
            this.photoCity = photoCity;
            this.photoDate = photoDate;
            this.extension = extension;
        }

        @Override
        public String toString() {
            return photoCity.trim()+ photoNumber +"."+extension;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhotoName() {
            return photoName;
        }

        public void setPhotoName(String photoName) {
            this.photoName = photoName;
        }

        public String getPhotoCity() {
            return photoCity;
        }

        public void setPhotoCity(String photoCity) {
            this.photoCity = photoCity;
        }

        public Date getPhotoDate() {
            return photoDate;
        }

        public void setPhotoDate(Date photoDate) {
            this.photoDate = photoDate;
        }

        public String getPhotoNumber() {
            return photoNumber;
        }

        public void setPhotoNumber(String photoNumber) {
            this.photoNumber = photoNumber;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

    }
}
