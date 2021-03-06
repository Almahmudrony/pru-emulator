package st61131.pru;

/*Generated by MPS */

import com.github.vlsi.pru.plc110.ArithmeticInstruction;
import com.github.vlsi.pru.plc110.CodeEmitter;
import com.github.vlsi.pru.plc110.Format2Instruction;
import com.github.vlsi.pru.plc110.JumpInstruction;
import com.github.vlsi.pru.plc110.Label;
import com.github.vlsi.pru.plc110.LdiInstruction;
import com.github.vlsi.pru.plc110.Pru;
import com.github.vlsi.pru.plc110.QuickBranchInstruction;
import com.github.vlsi.pru.plc110.Register;
import com.github.vlsi.pru.plc110.RegisterField;

import java.util.function.Consumer;

public class PRU_ABZ_ENCODER_CodeGenerator implements Consumer<CodeEmitter> {
  public void setA(Pru cpu, int value) {
    cpu.setReg(new Register(3, RegisterField.b0), value);
  }

  public void setB(Pru cpu, int value) {
    cpu.setReg(new Register(3, RegisterField.b1), value);
  }

  public void setZ(Pru cpu, int value) {
    cpu.setReg(new Register(3, RegisterField.b2), value);
  }

  public int getPosition(Pru cpu) {
    return cpu.getReg(new Register(1, RegisterField.w2));
  }

  public int getCounter(Pru cpu) {
    return cpu.getReg(new Register(1, RegisterField.w0));
  }

  public int getZeroDetected(Pru cpu) {
    return cpu.getReg(new Register(2, RegisterField.b3));
  }

  @Override
  public void accept(CodeEmitter ce) {
    Label orMatch1 = new Label("orMatch1");
    Label if3 = new Label("if3");
    Label endIf2 = new Label("endIf2");
    Label endIf0 = new Label("endIf0");
    Label endIf4 = new Label("endIf4");
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(3, RegisterField.b3), new Register(3, RegisterField.b0),
        new Register(2, RegisterField.b0)).setComment(
        "changedA => R3.b3, a => R3.b0, prevA => R2.b0"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.NE, orMatch1,
        new Register(3, RegisterField.b3), 0).setComment("changedA => R3.b3"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, endIf0,
        new Register(3, RegisterField.b1), new Register(2, RegisterField.b1)).setComment(
        "b => R3.b1, prevB => R2.b1"));
    ce.visitLabel(orMatch1);

    // Если a или b изменилось
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(1, RegisterField.w0), new Register(1, RegisterField.w0), 1).setComment(
        "counter => R1.w0"));
    //
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(4, RegisterField.b0), new Register(3, RegisterField.b0),
        new Register(3, RegisterField.b1)).setComment("aSameAsB => R4.b0, a => R3.b0, b => R3.b1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(4, RegisterField.b0), new Register(4, RegisterField.b0), 1).setComment(
        "aSameAsB => R4.b0"));

    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.NE, if3,
        new Register(4, RegisterField.b0), new Register(3, RegisterField.b3)).setComment(
        "aSameAsB => R4.b0, changedA => R3.b3"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(1, RegisterField.w2), new Register(1, RegisterField.w2), 1).setComment(
        "position => R1.w2"));

    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, endIf2,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(if3);
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.SUB,
        new Register(1, RegisterField.w2), new Register(1, RegisterField.w2), 1).setComment(
        "position => R1.w2"));

    ce.visitLabel(endIf2);


    ce.visitLabel(endIf0);

    //
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(2, RegisterField.b0), new Register(3, RegisterField.b0), 0).setComment(
        "prevA => R2.b0, a => R3.b0"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(2, RegisterField.b1), new Register(3, RegisterField.b1), 0).setComment(
        "prevB => R2.b1, b => R3.b1"));
    //
    // Call PRU_RTRIG
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(3, RegisterField.b3), new Register(3, RegisterField.b2), 0).setComment(
        "tmpPRU_RTRIG_0_in => R3.b3, z => R3.b2"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(4, RegisterField.b0), new Register(2, RegisterField.b2), 1).setComment(
        "tmpPRU_RTRIG_0_temp_b0 => R4.b0, tmpPRU_RTRIG_0_mem => R2.b2"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.AND,
        new Register(4, RegisterField.b0), new Register(3, RegisterField.b3),
        new Register(4, RegisterField.b0)).setComment(
        "tmpPRU_RTRIG_0_out => R4.b0, tmpPRU_RTRIG_0_in => R3.b3, tmpPRU_RTRIG_0_temp_b0 => R4.b0"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(2, RegisterField.b2), new Register(3, RegisterField.b3), 0).setComment(
        "tmpPRU_RTRIG_0_mem => R2.b2, tmpPRU_RTRIG_0_in => R3.b3"));
    // End PRU_RTRIG
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, endIf4,
        new Register(4, RegisterField.b0), 0).setComment("tmpPRU_RTRIG_0_out => R4.b0"));
    ce.visitInstruction(new LdiInstruction(new Register(1, RegisterField.w2), (short) 0).setComment(
        "position => R1.w2"));
    ce.visitInstruction(new LdiInstruction(new Register(2, RegisterField.b3), (short) 1).setComment(
        "zeroDetected => R2.b3"));

    ce.visitLabel(endIf4);

    //

  }
}
