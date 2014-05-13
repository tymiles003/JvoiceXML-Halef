/*
 * File:    $HeadURL: https://svn.code.sf.net/p/jvoicexml/code/trunk/org.jvoicexml.xml/src/org/jvoicexml/xml/vxml/Nomatch.java $
 * Version: $LastChangedRevision: 2325 $
 * Date:    $Date: 2010-08-25 09:23:51 +0200 (Wed, 25 Aug 2010) $
 * Author:  $LastChangedBy: schnelle $
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2005-2007 JVoiceXML group - http://jvoicexml.sourceforge.net
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Library General Public
 *  License as published by the Free Software Foundation; either
 *  version 2 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Library General Public License for more details.
 *
 *  You should have received a copy of the GNU Library General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.jvoicexml.xml.vxml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.jvoicexml.xml.Text;
import org.jvoicexml.xml.TokenList;
import org.jvoicexml.xml.XmlNode;
import org.jvoicexml.xml.XmlNodeFactory;
import org.jvoicexml.xml.ssml.Audio;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Catch a nomatch event.
 * <p>
 * The <code>&lt;nomatch&gt;</code> element abbreviates
 * <code>&lt;catch event="nomatch"&gt;</code> :
 * </p>
 * <p>
 * <code>
 * &lt;nomatch&gt;I heard something, but it wasn't a known city.&lt;/nomatch&gt;
 * </code>
 * </p>
 *
 * @see org.jvoicexml.xml.vxml.Catch
 *
 * @author Steve Doyle
 * @author Dirk Schnelle
 *
 * @version $Revision: 2325 $
 *
 * <p>
 * Copyright &copy; 2005-2007 JVoiceXML group - <a
 * href="http://jvoicexml.sourceforge.net"> http://jvoicexml.sourceforge.net/
 * </a>
 * </p>
 */
public final class Nomatch
        extends AbstractCatchElement {

    /** Name of the tag. */
    public static final String TAG_NAME = "nomatch";

    /**
     * Valid child tags for this node.
     */
    private static final Set<String> CHILD_TAGS;

    /** List with all events, caught by this catch element. */
    private static final TokenList EVENTS;

    /**
     * Supported attribute names for this node.
     */
    protected static final ArrayList<String> ATTRIBUTE_NAMES;

    /**
     * Set the valid attributes for this node.
     */
    static {
        ATTRIBUTE_NAMES = new java.util.ArrayList<String>();

        ATTRIBUTE_NAMES.add(ATTRIBUTE_COND);
        ATTRIBUTE_NAMES.add(ATTRIBUTE_COUNT);
    }

    /**
     * Set the valid child tags for this node.
     */
    static {
        CHILD_TAGS = new java.util.HashSet<String>();

        CHILD_TAGS.add(Assign.TAG_NAME);
        CHILD_TAGS.add(Prompt.TAG_NAME);
        CHILD_TAGS.add(Enumerate.TAG_NAME);
        CHILD_TAGS.add(Value.TAG_NAME);
        CHILD_TAGS.add(Audio.TAG_NAME);
        CHILD_TAGS.add(Clear.TAG_NAME);
        CHILD_TAGS.add(Data.TAG_NAME);
        CHILD_TAGS.add(Disconnect.TAG_NAME);
        CHILD_TAGS.add(Exit.TAG_NAME);
        CHILD_TAGS.add(Foreach.TAG_NAME);
        CHILD_TAGS.add(Goto.TAG_NAME);
        CHILD_TAGS.add(If.TAG_NAME);
        CHILD_TAGS.add(Log.TAG_NAME);
        CHILD_TAGS.add(Reprompt.TAG_NAME);
        CHILD_TAGS.add(Return.TAG_NAME);
        CHILD_TAGS.add(Script.TAG_NAME);
        CHILD_TAGS.add(Submit.TAG_NAME);
        CHILD_TAGS.add(Throw.TAG_NAME);
        CHILD_TAGS.add(Var.TAG_NAME);

        EVENTS = new TokenList(TAG_NAME);
    }

    /**
     * Construct a new nomatch object without a node.
     * <p>
     * This is necessary for the node factory.
     * </p>
     *
     * @see org.jvoicexml.xml.vxml.VoiceXmlNodeFactory
     */
    public Nomatch() {
        super(null);
    }

    /**
     * Construct a new nomatch object.
     *
     * @param node
     *        The encapsulated node.
     */
    Nomatch(final Node node) {
        super(node);
    }

    /**
     * Constructs a new node.
     *
     * @param n
     *            The encapsulated node.
     * @param factory
     *            The node factory to use.
     */
    private Nomatch(final Node n,
            final XmlNodeFactory<? extends XmlNode> factory) {
        super(n, factory);
    }

    /**
     * Get the name of the tag for the derived node.
     *
     * @return name of the tag.
     */
    public String getTagName() {
        return TAG_NAME;
    }

    /**
     * {@inheritDoc}
     */
    public XmlNode newInstance(final Node n,
            final XmlNodeFactory<? extends XmlNode> factory) {
        return new Nomatch(n, factory);
    }

    /**
     * Create a new text within this node.
     *
     * @param text
     *        The text to be added.
     * @return The new created text.
     */
    public Text addText(final String text) {
        final Document document = getOwnerDocument();
        final Node node = document.createTextNode(text);
        final Text textNode = new Text(node, getNodeFactory());
        appendChild(textNode);
        return textNode;
    }

    /**
     * {@inheritDoc}
     */
    protected boolean canContainChild(final String tagName) {
        return CHILD_TAGS.contains(tagName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokenList getEventList() {
        return EVENTS;
    }

    /**
     * Returns a collection of permitted attribute names for the node.
     *
     * @return A collection of attribute names that are allowed for the node
     */
    public Collection<String> getAttributeNames() {
        return ATTRIBUTE_NAMES;
    }
}
