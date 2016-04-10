package com.example.cxx.learnrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by CXX on 2016/4/10.
 */
class MyAdapter extends RecyclerView.Adapter implements View.OnClickListener{
    //模仿OnItemClickListener自定义接口
    public static interface OnRecyclerViewItemClickListener{
        void onItemClick(View view,String data);
    }
    private OnRecyclerViewItemClickListener myOnItemClickListener = null;

    @Override
    public void onClick(View v) {
        if(myOnItemClickListener!= null){
            //将点击事件转移给外面的调用者
            myOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void setOnItemCliclListener(OnRecyclerViewItemClickListener listener){
        this.myOnItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView tvTitle,tvContent;
        public ViewHolder(View root) {
            super(root);
            tvTitle = (TextView) root.findViewById(R.id.tvtitle);
            tvContent = (TextView) root.findViewById(R.id.tvcontent);
        }
        public TextView getTvContent() {
            return tvContent;
        }
        public TextView getTvTitle() {
            return tvTitle;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
         View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_set,null);
        ViewHolder vh = new ViewHolder(view);
        //为每个item添加点击事件
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder) viewHolder;
        ItemData itemData =data[i];
        vh.getTvTitle().setText(itemData.title);
        vh.getTvContent().setText(itemData.content);
        //定义tag全局变量，用于验证点击事件的发生
        vh.itemView.setTag(itemData.title);
    }

    @Override
    //子对象的数量
    public int getItemCount() {
        return data.length;
    }
    private ItemData[] data=new ItemData[]{
            new ItemData("标题1","内容1"),
            new ItemData("标题2","内容2"),
            new ItemData("标题3","内容3"),};
    //private String[] data = new String[]{"hello", "你好"};
}
