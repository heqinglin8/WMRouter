package com.quwan.tt.router.demo.basic;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.TextView;

import com.quwan.tt.router.annotation.RouterUri;
import com.quwan.tt.router.demo.R;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/3/27.
 */
@RouterUri(path = DemoConstant.JUMP_WITH_REQUEST)
public class TestUriRequestActivity extends BaseActivity {

    public static final String INTENT_TEST_INT = "test_int";
    public static final String INTENT_TEST_STR = "test_str";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_activity_text);

        TextView text = findViewById(R.id.text);

        Intent intent = getIntent();
        StringBuilder s = new StringBuilder();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                s.append(key).append(" = ").append(extras.get(key)).append('\n');
            }
        }
        text.setText(s.toString());
    }
}
