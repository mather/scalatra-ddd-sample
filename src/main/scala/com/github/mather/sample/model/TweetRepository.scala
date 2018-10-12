package com.github.mather.sample.model

trait TweetRepository {
  def findById(id: TweetId): Option[Tweet]
  def saveNewTweet(author: Author, message: Message): Option[Tweet]
}
