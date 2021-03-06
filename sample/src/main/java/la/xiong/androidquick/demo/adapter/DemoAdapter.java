package la.xiong.androidquick.demo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;

import java.util.List;

import la.xiong.androidquick.demo.adapter.provider.ImgItemProvider;
import la.xiong.androidquick.demo.adapter.provider.TextImgItemProvider;
import la.xiong.androidquick.demo.adapter.provider.TextItemProvider;
import la.xiong.androidquick.demo.bean.CBean;

/**
 * @author  ddnosh
 * @website http://blog.csdn.net/ddnosh
 */

public class DemoAdapter extends MultipleItemRvAdapter<CBean, BaseViewHolder> {
    public static final int TYPE_TEXT = 100;
    public static final int TYPE_IMG = 200;
    public static final int TYPE_TEXT_IMG = 300;

    public DemoAdapter(@Nullable List<CBean> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(CBean entity) {
        if (entity.getItemType() == CBean.SINGLE_TEXT) {
            return TYPE_TEXT;
        } else if (entity.getItemType() == CBean.SINGLE_IMG) {
            return TYPE_IMG;
        } else if (entity.getItemType() == CBean.TEXT_IMG) {
            return TYPE_TEXT_IMG;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new TextItemProvider());
        mProviderDelegate.registerProvider(new ImgItemProvider());
        mProviderDelegate.registerProvider(new TextImgItemProvider());
    }
}
