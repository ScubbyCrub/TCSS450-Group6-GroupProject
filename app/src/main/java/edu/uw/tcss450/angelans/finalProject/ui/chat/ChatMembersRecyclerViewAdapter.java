package edu.uw.tcss450.angelans.finalProject.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import edu.uw.tcss450.angelans.finalProject.R;
import edu.uw.tcss450.angelans.finalProject.databinding.FragmentChatMemberCardBinding;
import edu.uw.tcss450.angelans.finalProject.model.Contact;

public class ChatMembersRecyclerViewAdapter extends RecyclerView.Adapter<ChatMembersRecyclerViewAdapter.ChatMembersViewHolder> {
    private List<Contact> mContacts = new ArrayList<Contact>();
    private Consumer<Contact> addContact;
    private Consumer<Contact> deleteFromChat;

    public ChatMembersRecyclerViewAdapter(List<Contact> items, Consumer<Contact> addContact, Consumer<Contact> deleteFromChat) {
        this.addContact = addContact;
        this.mContacts = items;
        System.out.println("Contacts from Recycler View" + mContacts.toString());
        this.deleteFromChat = deleteFromChat;
    }

    @NonNull
    @Override
    public ChatMembersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatMembersViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_chat_member_card,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatMembersViewHolder holder, int position) {
        holder.setContact(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
    /**
     * Objects from this class represent an Individual row View from the List
     * of rows in the Blog Recycler View.
     */
    public class ChatMembersViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FragmentChatMemberCardBinding binding;
        private Contact mContact;

        public ChatMembersViewHolder(View view) {
            super(view);
            mView = view;
            binding = FragmentChatMemberCardBinding.bind(view);
        }

        void setContact(final Contact contact) {
            System.out.println("Contact:" + contact.toString());
            mContact = contact;
            binding.textMemberUsername.setText(contact.getUsername());
            binding.textMembersName.setText(contact.getFirstName() + " " + contact.getLastName());
        }
    }

}
