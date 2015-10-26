from hermes.browser import HermesBrowser
from hermes import Domain

hermes = HermesBrowser.getBrowser().getContext().lookup("EMS")
config = hermes.getDestinationConfig("sample", Domain.QUEUE)  # Domain.TOPIC for topics.
HermesBrowser.getBrowser().getActionFactory().createQueueBrowseAction(hermes, config)