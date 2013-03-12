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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class WarningPanel extends javax.swing.JPanel
{

  private List<Message> messages = new LinkedList<Message>();
  
  public void addMessage(final Message m)
  {
    messages.add(m);
    m.setCloseListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae)
      {
        messages.remove(m);
        warningContainer.remove(m);
        m.setCloseListener(null);
        revalidate();
        if (messages.isEmpty())
        {
          setVisible(false);
        }
      }
    });
    this.warningContainer.add(m);
    revalidate();
    setVisible(true);
  }
  
  /**
   * Creates new form WarningPanel
   */
  public WarningPanel()
  {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        warningContainer = new javax.swing.JPanel();

        warningContainer.setLayout(new javax.swing.BoxLayout(warningContainer, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(warningContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(warningContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel warningContainer;
    // End of variables declaration//GEN-END:variables
}
