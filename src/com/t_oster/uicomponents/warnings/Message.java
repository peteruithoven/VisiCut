/**
 * This file is part of VisiCut.
 * Copyright (C) 2011 - 2013 Thomas Oster <thomas.oster@rwth-aachen.de>
 * RWTH Aachen University - 52062 Aachen, Germany
 *
 *     VisiCut is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     VisiCut is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with VisiCut.  If not, see <http://www.gnu.org/licenses/>.
 **/
package com.t_oster.uicomponents.warnings;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class Message extends javax.swing.JPanel
{

  /**
   * Creates new form Message
   */
  public Message()
  {
    initComponents();
  }

  private void setBorderColor(Color color)
  {
    setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, color));
  }
  
  public enum Type
  {
    WARNING,
    ERROR,
    INFO,
    SUCCESS
  }
  
  private Type type = null;

  /**
   * Get the value of type
   *
   * @return the value of type
   */
  public Type getType()
  {
    return type;
  }

  /**
   * Set the value of type
   *
   * @param type new value of type
   */
  public void setType(Type type)
  {
    this.type = type;
    if (type != null)
    {
      switch (type)
      {
        case ERROR:
          this.setBackground(new Color(0xfe, 0xf5, 0xf1));
          this.setForeground(new Color(0x66, 0x00, 0x03));
          this.setBorderColor(new Color(0xc7, 0x00, 0x06));
          break;
        case WARNING:
          this.setBackground(new Color(0xfe, 0xfc, 0xe6));
          this.setForeground(new Color(0x66, 0x54, 0x00));
          this.setBorderColor(new Color(0xbf, 0x9e, 0x00));
          break;
        case INFO:
          this.setBackground(new Color(0xed, 0xfe, 0xff));
          this.setForeground(new Color(0x00, 0x52, 0x66));
          this.setBorderColor(new Color(0x00, 0x99, 0xbf));
          break;
        case SUCCESS:
          this.setBackground(new Color(0xf8, 0xff, 0xf1));
          this.setForeground(new Color(0x0a, 0x66, 0x00));
          this.setBorderColor(new Color(0x0f, 0x9c, 0x00));
          break;
      }
    }
  }

  private Action[] actions = null;
  private void setActions(Action[] actions)
  {
    this.actions = actions;
    JButton[] btAction = new JButton[]{btAction1, btAction2};
    for (int i = 0; i < btAction.length; i++)
    {
      if (actions != null && actions.length > i)
      {
        btAction[i].setText(actions[i].getName());
        btAction[i].setVisible(true);
      }
      else
      {
        btAction[i].setVisible(false);
      }
    }
  }
  
  public Message(String title, String text, Type type, Action[] actions)
  {
    this();
    this.setType(type != null ? type : Type.WARNING);
    this.lbTitle.setText(title);
    this.lbText.setLayout(new BoxLayout(this.lbText, BoxLayout.Y_AXIS));
    this.lbText.removeAll();
    int maxTextWidth = 80;
    for (String txt : text.split("\n"))
    {
      while (txt.length() > maxTextWidth)
      {
        this.lbText.add(new JLabel(txt.substring(0, maxTextWidth)));
        txt = txt.substring(maxTextWidth);
      }
      this.lbText.add(new JLabel(txt));
    }
    this.setActions(actions);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    lbTitle = new javax.swing.JLabel();
    btAction1 = new javax.swing.JButton();
    btAction2 = new javax.swing.JButton();
    lbText = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    btClose = new javax.swing.JButton();

    setBackground(new java.awt.Color(218, 115, 101));
    setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 18, 18)));
    setForeground(new java.awt.Color(89, 2, 2));

    lbTitle.setText("Warning");

    btAction1.setText("action1");
    btAction1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btAction1ActionPerformed(evt);
      }
    });

    btAction2.setText("action2");
    btAction2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btAction2ActionPerformed(evt);
      }
    });

    lbText.setOpaque(false);
    lbText.setLayout(new javax.swing.BoxLayout(lbText, javax.swing.BoxLayout.LINE_AXIS));

    jLabel1.setText("Something terrible has happened");
    lbText.add(jLabel1);

    btClose.setText("x");
    btClose.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btCloseActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(lbText, javax.swing.GroupLayout.PREFERRED_SIZE, 276, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btAction2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btAction1)
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addComponent(lbTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btClose))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lbTitle))
          .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lbText, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(btAction1)
            .addComponent(btAction2)))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void btAction1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAction1ActionPerformed
  {//GEN-HEADEREND:event_btAction1ActionPerformed
    if (this.actions[0].clicked())
    {
      fireClose();
    }
  }//GEN-LAST:event_btAction1ActionPerformed

  private void btAction2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAction2ActionPerformed
  {//GEN-HEADEREND:event_btAction2ActionPerformed
    if (this.actions[1].clicked())
    {
      fireClose();
    }
  }//GEN-LAST:event_btAction2ActionPerformed

  private void btCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCloseActionPerformed
  {//GEN-HEADEREND:event_btCloseActionPerformed
    fireClose();
  }//GEN-LAST:event_btCloseActionPerformed

  private ActionListener closeListener = null;

  public ActionListener getCloseListener()
  {
    return closeListener;
  }

  public void setCloseListener(ActionListener closeListener)
  {
    this.closeListener = closeListener;
  }

  private void fireClose()
  {
    if (closeListener != null)
    {
      closeListener.actionPerformed(new ActionEvent(this, 0, "close"));
    }
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btAction1;
  private javax.swing.JButton btAction2;
  private javax.swing.JButton btClose;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel lbText;
  private javax.swing.JLabel lbTitle;
  // End of variables declaration//GEN-END:variables
}
