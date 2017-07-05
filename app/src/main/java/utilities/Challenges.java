package utilities;

import android.graphics.drawable.Drawable;

/**
 * Created by danie on 05.07.2017.
 */

public class Challenges {

    private String challengeName;
    private String challengeDescription;
    private Drawable iconPath;

    public Challenges(String challengeName, String challengeDescription, Drawable icon){
        this.challengeName = challengeName;
        this.iconPath = iconPath;
        this.challengeDescription = challengeDescription;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public Drawable getIcon() {
        return iconPath;
    }

    public void setIcon(Drawable iconPath) {
        this.iconPath = iconPath;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }
}
