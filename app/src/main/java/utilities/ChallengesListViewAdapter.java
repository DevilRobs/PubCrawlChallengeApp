package utilities;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rober.pubcrawlchallengeapp.R;

import java.util.List;

/**
 * Created by danie on 05.07.2017.
 */

public class ChallengesListViewAdapter extends ArrayAdapter<Challenges> {


        private String TAG = "ChallengeAdapter";


        public ChallengesListViewAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        public ChallengesListViewAdapter(Context context, int resource, List<Challenges> items) {
            super(context, resource, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.challenge_list_item, null);
            }

            Challenges c = getItem(position);

            if (c != null) {
                TextView tv_challengeName = (TextView) v.findViewById(R.id.tv_challengeName);
                TextView tv_decription = (TextView) v.findViewById(R.id.tv_challengeDescription);
                ImageView iv_challengeIcon = (ImageView) v.findViewById(R.id.iv_challengeIcon);

                if (tv_challengeName != null) {
                    tv_challengeName.setText(c.getChallengeName());
                }

                if (tv_decription != null) {
                    tv_decription.setText(c.getChallengeDescription());
                }

                if (iv_challengeIcon != null) {
                    Log.d(TAG, "challengeIcon reached");
                    iv_challengeIcon.setImageResource(c.getIcon());
                }
            }

            return v;
        }

    }




