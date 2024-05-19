package com.ghavio.myapplication.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.ghavio.myapplication.NewsItem;
import com.ghavio.myapplication.NewsItemAdapter;
import com.ghavio.myapplication.databinding.FragmentDashboardBinding;
import com.ghavio.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Prepare dummy news data (replace with your actual data loading logic)
        NewsItem[] newsItems = new NewsItem[]{
                new NewsItem("Title 1", "Description 1", R.drawable.razegoofy),
                new NewsItem("Title 2", "Description 2", R.drawable.razegoofy),
                new NewsItem("Title 3", "Description 3", R.drawable.razegoofy),
                new NewsItem("Title 4", "Description 4", R.drawable.razegoofy),
                new NewsItem("Title 5", "Description 5", R.drawable.razegoofy),
                new NewsItem("Title 6", "Description 6", R.drawable.razegoofy),
                new NewsItem("Title 7", "Description 7", R.drawable.razegoofy),
                new NewsItem("Title 8", "Description 8", R.drawable.razegoofy),
                new NewsItem("Title 9", "Description 9", R.drawable.razegoofy),
                new NewsItem("Title 10", "Description 10", R.drawable.razegoofy),
                // Add more NewsItem objects here
        };

        // Convert array to list
        List<NewsItem> newsItemsList = null;
        try {
            newsItemsList = new ArrayList<>(Arrays.asList(newsItems));
        } catch (Exception e) {
            Log.e("DashboardFragment", "Error converting array to list:", e);
        }

        // Check if conversion succeeded
        if (newsItemsList != null) {
            // Get a reference to the RecyclerView
            RecyclerView newsRecyclerView = binding.getRoot().findViewById(R.id.news_recycler_view);

            // Create a NewsItemAdapter and set the data
            NewsItemAdapter adapter = new NewsItemAdapter(newsItemsList);

            // Set layout manager for the RecyclerView (optional, but improves performance)
            newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            // Set the adapter to the RecyclerView
            newsRecyclerView.setAdapter(adapter);
        } else {
            // Handle conversion error (display error message, etc.)
            Log.e("DashboardFragment", "Failed to convert news items array to list.");
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
