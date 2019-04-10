package org.huaiangg.mt.mtclient.frags.panel;

import android.view.View;

import org.huaiangg.mt.common.widget.recycler.RecyclerAdapter;
import org.huaiangg.mt.face.Face;
import org.huaiangg.mt.mtclient.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaceAdapter extends RecyclerAdapter<Face.Bean> {

    public FaceAdapter(List<Face.Bean> beans, AdapterListener<Face.Bean> listener) {
        super(beans, listener);
    }

    @Override
    protected int getItemViewType(int position, Face.Bean bean) {
        return R.layout.cell_face;
    }

    @Override
    protected ViewHolder<Face.Bean> onCreateViewHolder(View root, int viewType) {
        return new FaceHolder(root);
    }
}

