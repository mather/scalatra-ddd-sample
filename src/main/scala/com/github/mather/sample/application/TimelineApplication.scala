package com.github.mather.sample.application

import com.github.mather.sample.model._

class TimelineApplication {
  def showGlobalTimeline()(implicit timelineRepository: TimelineRepository): Timeline = {
    timelineRepository.getGlobalTimeline()
  }

  def postNewTweet(author: Author, message: Message)(implicit tweetRepository: TweetRepository): Option[Tweet] = {
    tweetRepository.saveNewTweet(author, message)
  }
}
