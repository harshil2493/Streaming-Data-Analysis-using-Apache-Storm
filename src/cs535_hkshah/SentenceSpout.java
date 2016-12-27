package cs535_hkshah;
import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class SentenceSpout extends BaseRichSpout{
	
	private SpoutOutputCollector collector; 
	private String[] sentences = { 
	"my dog has fleas", 
	
	"i like cold beverages", 
	
	"the dog ate my homework", 
	
	"don't have a truck", 
	
	"i don't think i like fleas" 
	}; 
	
	private int index = 0;
	
	@Override
	public void nextTuple() { 
		this.collector.emit(new Values(sentences[index])); 
		index ++; 
		if (index >= sentences.length) { 
			index = 0; 
		} 
//		Utils.waitForMillis(1);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void open(Map config, TopologyContext context, SpoutOutputCollector collector) { 		
			this.collector = collector; 
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("sentence"));
		
	}

}
