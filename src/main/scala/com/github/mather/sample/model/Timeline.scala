package com.github.mather.sample.model

trait Timeline {
  def tweets: TweetList
  // TODO: implement more for timeline responsibility
  def isEmpty: Boolean = tweets.list.isEmpty
}

class GlobalTimeline(val tweets: TweetList) extends Timeline
