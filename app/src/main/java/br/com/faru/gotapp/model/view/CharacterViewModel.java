package br.com.faru.gotapp.model.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import br.com.faru.gotapp.model.Character;
import br.com.faru.gotapp.util.Constants;

/**
 * Created by faru on 27/01/17.
 */

public class CharacterViewModel implements Parcelable {

    private String displayName;
    private String name;
    private String gender;
    private String culture;
    private String born;
    private String died;
    private String titles;
    private String aliases;
    private String father;
    private String mother;
    private String spouse;

    public CharacterViewModel(Character character) {

        final StringBuilder sbDisplayName = new StringBuilder();
        if (!TextUtils.isEmpty(character.getName())) {
            sbDisplayName.append(character.getName()).append(" ");
        }

        if (character.getAliases() != null && character.getAliases().size() > 0) {
            sbDisplayName.append(character.getAliases().get(0));
        }

        displayName = sbDisplayName.toString();
        name = TextUtils.isEmpty(character.getName()) ? Constants.UNKNOWN : character.getName();
        gender = TextUtils.isEmpty(character.getGender()) ? Constants.UNKNOWN : character.getGender();
        culture = TextUtils.isEmpty(character.getCulture()) ? Constants.UNKNOWN : character.getCulture();
        born = TextUtils.isEmpty(character.getBorn()) ? Constants.UNKNOWN : character.getBorn();
        died = TextUtils.isEmpty(character.getDied()) ? Constants.UNKNOWN : character.getDied();

        father = TextUtils.isEmpty(character.getFather()) ? Constants.UNKNOWN : character.getFather();
        mother = TextUtils.isEmpty(character.getMother()) ? Constants.UNKNOWN : character.getMother();
        spouse = TextUtils.isEmpty(character.getSpouse()) ? Constants.UNKNOWN : character.getSpouse();

        titles = "";
        int i = 0;
        if (character.getTitles() != null && character.getTitles().size() > 0) {
            for (String title : character.getTitles()) {
                if (!TextUtils.isEmpty(title)) {
                    i++;
                    titles += title;
                    if (i < character.getTitles().size()) {
                        titles += "\n";
                    }
                }
            }
        }

        aliases = "";
        i = 0;
        if (character.getAliases() != null && character.getAliases().size() > 0) {
            for (String alias : character.getAliases()) {
                if (!TextUtils.isEmpty(alias)) {
                    i++;
                    aliases += alias;
                    if (i < character.getAliases().size()) {
                        aliases += "\n";
                    }
                }
            }
        }
    }

    protected CharacterViewModel(Parcel in) {
        displayName = in.readString();
        name = in.readString();
        gender = in.readString();
        culture = in.readString();
        born = in.readString();
        died = in.readString();
        titles = in.readString();
        aliases = in.readString();
        father = in.readString();
        mother = in.readString();
        spouse = in.readString();
    }

    public static final Creator<CharacterViewModel> CREATOR = new Creator<CharacterViewModel>() {
        @Override
        public CharacterViewModel createFromParcel(Parcel in) {
            return new CharacterViewModel(in);
        }

        @Override
        public CharacterViewModel[] newArray(int size) {
            return new CharacterViewModel[size];
        }
    };

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(displayName);
        parcel.writeString(name);
        parcel.writeString(gender);
        parcel.writeString(culture);
        parcel.writeString(born);
        parcel.writeString(died);
        parcel.writeString(titles);
        parcel.writeString(aliases);
        parcel.writeString(father);
        parcel.writeString(mother);
        parcel.writeString(spouse);
    }
}
