package com.example.snlcomponent;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commonbasiclibrary.service.AutowiredService;
import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;

@RouteNode(path = "/ShareActivity",desc = "SNL组件，分享界面")
public class ShareActivity extends AppCompatActivity {

    @Autowired
    String shareStr;

    private ClipboardManager clip;

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutowiredService.Factory.getSingletonImpl().autowire(this);
        setContentView(R.layout.activity_share);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.BOTTOM;
        params.y = 100;
        getWindow().setAttributes(params);
        gridView = findViewById(R.id.shareGridView);
        final ShareAdapter mAdapter = new ShareAdapter(this);
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == mAdapter.getCount() - 1) {
                    clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    clip.setText(shareStr);
                    String body = clip.getText().toString();
                    if (!TextUtils.isEmpty(body)) {
                        Toast.makeText(ShareActivity.this, "复制成功", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                } else {
                    Toast.makeText(ShareActivity.this, shareStr, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }


    public class ShareAdapter extends BaseAdapter {

        Context mContext;

        public ShareAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Integer getItem(int position) {
            return mThumbIds[position];
        }

        @Override
        public long getItemId(int psition) {
            return psition;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_share, null);
                viewHolder.imageView = (ImageView) convertView
                        .findViewById(R.id.imageViewShare);
                viewHolder.textView =  convertView
                        .findViewById(R.id.textViewShare);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.imageView.setImageResource(mThumbIds[position]);
            viewHolder.textView.setText(strings[position]);

            return convertView;
        }

        private Integer[] mThumbIds = {R.drawable.share_weixin1,
                R.drawable.share_friend, R.drawable.share_qq1,
                R.drawable.share_qqzone, R.drawable.share_sina,
                R.drawable.share_link };

        public  String[] strings = { "微信好友", "朋友圈", "QQ好友",
                "QQ动态", "微博", "复制链接"};

        class ViewHolder {
            ImageView imageView;
            TextView textView;
        }
    }
}
