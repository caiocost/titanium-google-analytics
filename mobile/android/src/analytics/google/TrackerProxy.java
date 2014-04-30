/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package analytics.google;

import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.HitBuilders;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;

import java.util.HashMap;
import java.lang.Long;

// This proxy can be created by calling GoogleAnalytics.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule=GoogleAnalyticsModule.class)
public class TrackerProxy extends KrollProxy
{
	// Standard Debugging variables
	private static final String LCAT = "TrackerProxy";
	private static final boolean DBG = TiConfig.LOGD;

	private Tracker tracker;

	// Constructor
	public TrackerProxy(Tracker t)
	{
		super();
		tracker = t;
	}

	@Kroll.method
	public void setScreenName(String path)
	{
		tracker.setScreenName(path);
	}

	@Kroll.method
	public void trackEvent(HashMap props)
	{
		KrollDict propsDict = new KrollDict(props);
		String category = TiConvert.toString(propsDict, "category");
		String action = TiConvert.toString(propsDict, "action");
		String label = TiConvert.toString(propsDict, "label");
		long value = TiConvert.toInt(propsDict, "value");
		
		HitBuilders.EventBuilder hitBuilder = new HitBuilders.EventBuilder()
			.setCategory(category)
			.setAction(action)
			.setLabel(label)
			.setValue(value);
		
		
		// custom dimension
		Object cd = propsDict.get("customDimension");
		if (cd instanceof HashMap) {
			HashMap dict = (HashMap) cd;
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				String val = TiConvert.toString(dict.get(key));
				
				if (idx > 0) {
					hitBuilder.setCustomDimension(idx, val);
				}
			}
		}
		
		// custom metric
		Object cm = propsDict.get("customMetric");
		if (cm instanceof HashMap) {
			HashMap dict = (HashMap) cm;
			
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				float val = TiConvert.toFloat(dict.get(key));
				
				if (idx > 0) {
					hitBuilder.setCustomMetric(idx, val);
				}
			}
		}
		
		tracker.send(hitBuilder.build());
	}

	@Kroll.method
	public void trackScreen(HashMap props)
	{
		KrollDict propsDict = new KrollDict(props);
		String path = TiConvert.toString(propsDict, "path");
		
		tracker.setScreenName(path);
		
		HitBuilders.AppViewBuilder hitBuilder = new HitBuilders.AppViewBuilder();
		
		// custom dimension
		Object cd = propsDict.get("customDimension");
		if (cd instanceof HashMap) {
			HashMap dict = (HashMap) cd;
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				String val = TiConvert.toString(dict.get(key));
			
				if (idx > 0) {
					hitBuilder.setCustomDimension(idx, val);
				}
			}
		}
				
		// custom metric
		Object cm = propsDict.get("customMetric");
		if (cm instanceof HashMap) {
			HashMap dict = (HashMap) cm;
		
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				float val = TiConvert.toFloat(dict.get(key));
			
				if (idx > 0) {
					hitBuilder.setCustomMetric(idx, val);
				}
			}
		}
		
		tracker.send(hitBuilder.build());
	}

	@Kroll.method
	public void trackTiming(HashMap props)
	{
		KrollDict propsDict = new KrollDict(props);
		String category = TiConvert.toString(propsDict, "category");
		String name = TiConvert.toString(propsDict, "name");
		String label = TiConvert.toString(propsDict, "label");
		long interval = TiConvert.toInt(propsDict, "time");
		
		
		HitBuilders.TimingBuilder hitBuilder = new HitBuilders.TimingBuilder()
			.setCategory(category)
			.setValue(interval)
			.setVariable(name)
			.setLabel(label);
		
		
		// custom dimension
		Object cd = propsDict.get("customDimension");
		if (cd instanceof HashMap) {
			HashMap dict = (HashMap) cd;
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				String val = TiConvert.toString(dict.get(key));
				
				if (idx > 0) {
					hitBuilder.setCustomDimension(idx, val);
				}
			}
		}
		
		// custom metric
		Object cm = propsDict.get("customMetric");
		if (cm instanceof HashMap) {
			HashMap dict = (HashMap) cm;
			
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				float val = TiConvert.toFloat(dict.get(key));
				
				if (idx > 0) {
					hitBuilder.setCustomMetric(idx, val);
				}
			}
		}
		
		tracker.send(hitBuilder.build());
	}

	@Kroll.method
	public void trackSocial(HashMap props)
	{
		KrollDict propsDict = new KrollDict(props);
		String network = TiConvert.toString(propsDict, "network");
		String action = TiConvert.toString(propsDict, "action");
		String target = TiConvert.toString(propsDict, "target");
		
		
		HitBuilders.SocialBuilder hitBuilder = new HitBuilders.SocialBuilder()
			.setNetwork(network)
			.setAction(action)
			.setTarget(target);
		
		
		// custom dimension
		Object cd = propsDict.get("customDimension");
		if (cd instanceof HashMap) {
			HashMap dict = (HashMap) cd;
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				String val = TiConvert.toString(dict.get(key));
				
				if (idx > 0) {
					hitBuilder.setCustomDimension(idx, val);
				}
			}
		}
		
		// custom metric
		Object cm = propsDict.get("customMetric");
		if (cm instanceof HashMap) {
			HashMap dict = (HashMap) cm;
			
			for (Object key : dict.keySet()) {
				int idx = TiConvert.toInt(key);
				float val = TiConvert.toFloat(dict.get(key));
				
				if (idx > 0) {
					hitBuilder.setCustomMetric(idx, val);
				}
			}
		}
		
		tracker.send(hitBuilder.build());
	}
}
