package com.github.mather.sample

import com.github.mather.sample.application.TimelineApplication
import com.github.mather.sample.infrastructure.onmemory.{OnMemoryTimelineDataSource, OnMemoryTweetDataSource}
import com.github.mather.sample.model._
import org.scalatra.ScalatraServlet

class MyScalatraServlet extends ScalatraServlet {
  val application = new TimelineApplication()
  implicit val tweetRepository: TweetRepository = OnMemoryTweetDataSource
  implicit val timelineRepository: TimelineRepository = OnMemoryTimelineDataSource

  get("/") {
    val timeline = application.showGlobalTimeline()
    views.html.index(timeline)
  }

  post("/") {
    // TODO: Author login
    val author = Author(AuthorId("sample"), AuthorName("Sample User"))
    val message = Message.create(params("message"))
    val newTweet = application.postNewTweet(author, message)

    newTweet match {
      case Some(tweet) => redirect("/")
      case None => {
        val timeline = application.showGlobalTimeline()
        views.html.index(timeline, Option("Failed to tweet."))
      }
    }
  }

}
