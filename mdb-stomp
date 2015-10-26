import stomp
import time

class SampleListener(object):
  def on_message(self, headers, message):
    print message

conn = stomp.Connection10()

conn.set_listener('SampleListener', SampleListener())

conn.start()

conn.connect()

conn.subscribe('/topic/SampleTopic')

time.sleep(1) # secs

conn.disconnect()