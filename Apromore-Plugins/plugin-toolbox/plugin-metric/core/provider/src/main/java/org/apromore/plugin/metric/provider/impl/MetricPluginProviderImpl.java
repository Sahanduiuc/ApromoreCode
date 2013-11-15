package org.apromore.plugin.metric.provider.impl;

import java.util.*;

import javax.annotation.Resource;

import org.apromore.plugin.exception.PluginNotFoundException;
import org.apromore.plugin.metric.MetricPlugin;
import org.apromore.plugin.metric.provider.MetricPluginProvider;
import org.apromore.plugin.provider.PluginProviderHelper;
import org.springframework.stereotype.Component;

@Component
public class MetricPluginProviderImpl implements MetricPluginProvider {
    
    @Resource
    private Set<MetricPlugin> metricPluginSet;

    public Set<MetricPlugin> getMetricPluginSet() {
        return metricPluginSet;
    }

    public void setMetricPluginSet(final Set<MetricPlugin> metricPluginSet) {
        this.metricPluginSet = metricPluginSet;
    }



    /**
     * (non-Javadoc)
     * @see org.apromore.plugin.metric.provider.MetricPluginProvider#listAll()
     */
    @Override
    public Collection<MetricPlugin> listAll() {
        return Collections.unmodifiableSet(getMetricPluginSet());
    }

    /**
     * (non-Javadoc)
     * @see org.apromore.plugin.metric.provider.MetricPluginProvider#findByName(String)
     */
    @Override
    public MetricPlugin findByName(String name) throws PluginNotFoundException {
        final Set<MetricPlugin> resultList = findAllMetricPlugins(name, null);
        Iterator<MetricPlugin> iterator = resultList.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new PluginNotFoundException("Could not find metric plugin with name: " + ((name != null) ? name : "null"));
    }

    /**
     * (non-Javadoc)
     * @see org.apromore.plugin.metric.provider.MetricPluginProvider#findByNameAndVersion(String, String)
     */
    @Override
    public MetricPlugin findByNameAndVersion(String name, String version) throws PluginNotFoundException {
        final Set<MetricPlugin> resultList = findAllMetricPlugins(name, version);
        Iterator<MetricPlugin> iterator = resultList.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new PluginNotFoundException("Could not find metric plugin with name: " + ((name != null) ? name : "null") +
                " version: " + ((version != null) ? version : "null"));
    }

    /**
     * Returns a List of Plugins with matching parameters.
     * @param name       can be NULL
     * @param version    can be NULL
     * @return List of Plugins or empty List
     */
    private Set<MetricPlugin> findAllMetricPlugins(final String name, final String version) throws PluginNotFoundException {
        final Set<MetricPlugin> plugList = new HashSet<>();

        for (final MetricPlugin c : getMetricPluginSet()) {
            if (PluginProviderHelper.compareNullable(name, c.getName()) &&
                    PluginProviderHelper.compareNullable(version, c.getVersion())) {
                plugList.add(c);
            }
        }
        if (plugList.isEmpty()) {
            throw new PluginNotFoundException("Could not find plugin with name: " + ((name != null) ? name : "null") +
                    " version: " + ((version != null) ? version : "null"));
        }
        return plugList;
    }

}
