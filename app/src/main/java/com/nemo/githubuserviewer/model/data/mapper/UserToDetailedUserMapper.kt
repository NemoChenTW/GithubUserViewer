package com.nemo.githubuserviewer.model.data.mapper

import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.database.entity.User

class UserToDetailedUserMapper : Mapper<User, DetailedUser> {
    override fun map(input: User): DetailedUser {
        return DetailedUser(
            hasDetailed = input.hasDetailed,
            avatar_url = input.avatar_url,
            bio = input.bio.orEmpty(),
            blog = input.blog.orEmpty(),
            company = input.company.orEmpty(),
            created_at = input.created_at.orEmpty(),
            email = input.email.orEmpty(),
            events_url = input.events_url,
            followers = input.followers ?: 0,
            followers_url = input.followers_url,
            following = input.following ?: 0,
            following_url = input.following_url,
            gists_url = input.gists_url,
            gravatar_id = input.gravatar_id,
            hireable = input.hireable ?: false,
            html_url = input.html_url,
            id = input.id,
            location = input.location.orEmpty(),
            login = input.login,
            name = input.name.orEmpty(),
            node_id = input.node_id,
            organizations_url = input.organizations_url,
            public_gists = input.public_gists ?: 0,
            public_repos = input.public_repos ?: 0,
            received_events_url = input.received_events_url,
            repos_url = input.repos_url,
            site_admin = input.site_admin ?: false,
            starred_url = input.starred_url,
            subscriptions_url = input.subscriptions_url,
            twitter_username = input.twitter_username.orEmpty(),
            type = input.type,
            updated_at = input.updated_at.orEmpty(),
            url = input.url
        )
    }
}