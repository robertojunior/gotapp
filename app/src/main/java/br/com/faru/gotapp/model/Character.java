package br.com.faru.gotapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Character implements Parcelable {

    /**
     * url : https://anapioficeandfire.com/api/characters/583
     * name : Jon Snow
     * gender : Male
     * culture : Northmen
     * born : In 283 AC
     * died :
     * titles : ["Lord Commander of the Night's Watch"]
     * aliases : ["Lord Snow","Ned Stark's Bastard","The Snow of Winterfell","The Crow-Come-Over"]
     * father :
     * mother :
     * spouse :
     * allegiances : ["https://anapioficeandfire.com/api/houses/362"]
     * books : ["https://anapioficeandfire.com/api/books/5"]
     * tvSeries : ["Season 1","Season 2","Season 3","Season 4","Season 5","Season 6"]
     * povBooks : ["https://anapioficeandfire.com/api/books/1"]
     * playedBy : ["Kit Harington"]
     */

    private String url;
    private String name;
    private String gender;
    private String culture;
    private String born;
    private String died;
    private String father;
    private String mother;
    private String spouse;
    private List<String> titles;
    private List<String> aliases;
    private List<String> allegiances;
    private List<String> books;
    private List<String> povBooks;
    private List<String> tvSeries;
    private List<String> playedBy;

    protected Character(Parcel in) {
        url = in.readString();
        name = in.readString();
        gender = in.readString();
        culture = in.readString();
        born = in.readString();
        died = in.readString();
        father = in.readString();
        mother = in.readString();
        spouse = in.readString();
        titles = in.createStringArrayList();
        aliases = in.createStringArrayList();
        allegiances = in.createStringArrayList();
        books = in.createStringArrayList();
        povBooks = in.createStringArrayList();
        tvSeries = in.createStringArrayList();
        playedBy = in.createStringArrayList();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getAllegiances() {
        return allegiances;
    }

    public void setAllegiances(List<String> allegiances) {
        this.allegiances = allegiances;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public List<String> getPovBooks() {
        return povBooks;
    }

    public void setPovBooks(List<String> povBooks) {
        this.povBooks = povBooks;
    }

    public List<String> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<String> tvSeries) {
        this.tvSeries = tvSeries;
    }

    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeString(name);
        parcel.writeString(gender);
        parcel.writeString(culture);
        parcel.writeString(born);
        parcel.writeString(died);
        parcel.writeString(father);
        parcel.writeString(mother);
        parcel.writeString(spouse);
        parcel.writeStringList(titles);
        parcel.writeStringList(aliases);
        parcel.writeStringList(allegiances);
        parcel.writeStringList(books);
        parcel.writeStringList(povBooks);
        parcel.writeStringList(tvSeries);
        parcel.writeStringList(playedBy);
    }
}
