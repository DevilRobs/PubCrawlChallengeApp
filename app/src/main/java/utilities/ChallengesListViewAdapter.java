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

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by danie on 05.07.2017.
 */

public class ChallengesListViewAdapter extends ArrayAdapter<Challenges> {


        private String TAG = "ChallengeAdapter";
        private int layout = 1;

        public ChallengesListViewAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        public ChallengesListViewAdapter(Context context, int resource, List<Challenges> items) {
            super(context, resource, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;



            Challenges c = getItem(position);

            if (c != null) {
                switch (layout) {
                    case 1:
                        if (v == null) {
                            LayoutInflater vi;
                            vi = LayoutInflater.from(getContext());
                            v = vi.inflate(R.layout.challenge_list_item, null);
                        }

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
                        iv_challengeIcon.setImageResource(c.getIcon());
                    }
                    break;
                    case 2:
                        if (v == null) {
                            LayoutInflater vi;
                            vi = LayoutInflater.from(getContext());
                            v = vi.inflate(R.layout.challenge_list_item_title_icon, null);
                        }
                        TextView tv_title = (TextView) v.findViewById(R.id.tv_listItemTitle);
                        ImageView iv_Listicon = (ImageView) v.findViewById(R.id.iv_listItemIcon);
                        if(iv_Listicon != null)
                            iv_Listicon.setImageResource(c.getIcon());

                        if(tv_title != null)
                            tv_title.setText(c.getChallengeName());
                        break;
                    case 3:

                        if (v == null) {
                            LayoutInflater vi;
                            vi = LayoutInflater.from(getContext());
                            v = vi.inflate(R.layout.challenge_list_item_icon, null);
                        }

                        Log.d("justicon", c.getChallengeName() + " " + c.getChallengeDescription() + " " + c.getIcon());
                        ImageView iv_icon = (ImageView) v.findViewById(R.id.iv_icon);
                        if(iv_icon != null)
                        iv_icon.setImageResource(c.getIcon());

                    break;
                }
            }

            return v;
        }

        public void setLayout(int layout){
            this.layout = layout;
        }

    }




