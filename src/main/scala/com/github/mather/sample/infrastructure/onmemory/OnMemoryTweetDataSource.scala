package com.github.mather.sample.infrastructure.onmemory

import java.util.UUID

import com.github.mather.sample.model._
import org.joda.time.DateTime

object OnMemoryTweetDataSource extends TweetRepository {
  private var mutableTweetList: TweetList = TweetList(List())

  override def saveNewTweet(author: Author, message: Message): Option[Tweet] = {
    val uuid: UUID = UUID.randomUUID()
    val id: TweetId = TweetId(uuid.toString())
    val createdAt: DateTime = DateTime.now()
    val tweet = new Tweet(id, author, message, createdAt)
    this.appendNewTweet(tweet)
    Option(tweet)
  }

  def appendNewTweet(tweet: Tweet): Unit = {
    val TweetList(list) = mutableTweetList
    val newList = tweet +: list
    mutableTweetList = TweetList(newList)
  }

  override def findById(tweetId: TweetId): Option[Tweet] = {
    val TweetList(list) = mutableTweetList
    list.find(tweet => tweet.id == tweetId)
  }

  def tweetList: TweetList = mutableTweetList

}
