package com.nemo.githubuserviewer.model.data.mapper

import com.nemo.githubuserviewer.model.data.ListedUser
import com.nemo.githubuserviewer.model.database.entity.User

class UserToListedUserMapper : Mapper<User, ListedUser> {
    override fun map(input: User): ListedUser {
        return ListedUser(
            avatar_url = input.avatar_url,
            events_url = input.events_url,
            followers_url = input.followers_url,
            following_url = input.following_url,
            gists_url = input.gists_url,
            gravatar_id = input.gravatar_id,
            html_url = input.html_url,
            id = input.id,
            login = input.login,
            node_id = input.node_id,
            organizations_url = input.organizations_url,
            received_events_url = input.received_events_url,
            repos_url = input.repos_url,
            site_admin = input.site_admin,
            starred_url = input.starred_url,
            subscriptions_url = input.subscriptions_url,
            type = input.type,
            url = input.url
        )
    }
}