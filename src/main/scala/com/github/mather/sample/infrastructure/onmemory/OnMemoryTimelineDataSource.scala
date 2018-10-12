package com.github.mather.sample.infrastructure.onmemory

import com.github.mather.sample.model.{GlobalTimeline, Timeline, TimelineRepository, TweetList}

object OnMemoryTimelineDataSource extends TimelineRepository {
  override def getGlobalTimeline(): Timeline = {
    val tweetList: TweetList = OnMemoryTweetDataSource.tweetList
    new GlobalTimeline(tweetList)
  }
}
