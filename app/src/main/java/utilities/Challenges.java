package utilities;

import android.graphics.drawable.Drawable;

/**
 * Created by danie on 05.07.2017.
 */

public class Challenges {

    private String challengeName;
    private String challengeDescription;
    private int drawable;

    public Challenges(String challengeName, String challengeDescription, int drawable){
        this.challengeName = challengeName;
        this.drawable = drawable;
        this.challengeDescription = challengeDescription;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public int getIcon() {
        return drawable;
    }

    public void setIcon(int drawable) {
        this.drawable = drawable;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }
}
