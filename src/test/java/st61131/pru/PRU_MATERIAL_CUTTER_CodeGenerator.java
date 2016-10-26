package st61131.pru;

/*Generated by MPS */

import com.github.vlsi.pru.plc110.ArithmeticInstruction;
import com.github.vlsi.pru.plc110.CodeEmitter;
import com.github.vlsi.pru.plc110.Format2Instruction;
import com.github.vlsi.pru.plc110.JumpInstruction;
import com.github.vlsi.pru.plc110.Label;
import com.github.vlsi.pru.plc110.LdiInstruction;
import com.github.vlsi.pru.plc110.MemoryTransferInstruction;
import com.github.vlsi.pru.plc110.QuickBranchInstruction;
import com.github.vlsi.pru.plc110.Register;
import com.github.vlsi.pru.plc110.RegisterField;

import java.util.function.Consumer;

public class PRU_MATERIAL_CUTTER_CodeGenerator implements Consumer<CodeEmitter> {


  @Override
  public void accept(CodeEmitter ce) {
    Label startWhileBody0 = new Label("startWhileBody0");
    Label orMatch3 = new Label("orMatch3");
    Label if5 = new Label("if5");
    Label endIf4 = new Label("endIf4");
    Label endIf2 = new Label("endIf2");
    Label endIf6 = new Label("endIf6");
    Label if8 = new Label("if8");
    Label endIf9 = new Label("endIf9");
    Label elsIf13 = new Label("elsIf13");
    Label orMatch12 = new Label("orMatch12");
    Label if11 = new Label("if11");
    Label endIf10 = new Label("endIf10");
    Label elsIf15 = new Label("elsIf15");
    Label endIf14 = new Label("endIf14");
    Label endIf7 = new Label("endIf7");
    Label if17 = new Label("if17");
    Label endIf16 = new Label("endIf16");
    Label endIf18 = new Label("endIf18");
    Label endWhile1 = new Label("endWhile1");
    ce.visitLabel(startWhileBody0);
    // Call PRU_INPUTS
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.LSR,
        new Register(6, RegisterField.b1), new Register(31, RegisterField.dw), 21).setComment(
        "IN_1 хранится в 21-ом бите, поэтому сдвигаем вправо на 21, inputs_in1 => R6.b1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.AND,
        new Register(6, RegisterField.b1), new Register(6, RegisterField.b1), 1).setComment(
        "получаем значение IN_1, inputs_in1 => R6.b1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.LSR,
        new Register(6, RegisterField.b2), new Register(31, RegisterField.dw), 22).setComment(
        "IN_1 хранится в 22-ом бите, поэтому сдвигаем вправо на 22, inputs_in2 => R6.b2"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.AND,
        new Register(6, RegisterField.b2), new Register(6, RegisterField.b2), 1).setComment(
        "получаем значение IN_2, inputs_in2 => R6.b2"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.LSR,
        new Register(6, RegisterField.b3), new Register(31, RegisterField.dw), 2).setComment(
        "IN_1 хранится в 2-ом бите, поэтому сдвигаем вправо на 2, inputs_in3 => R6.b3"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.AND,
        new Register(6, RegisterField.b3), new Register(6, RegisterField.b3), 1).setComment(
        "получаем значение IN_3, inputs_in3 => R6.b3"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.LSR,
        new Register(7, RegisterField.b0), new Register(31, RegisterField.dw), 3).setComment(
        "IN_1 хранится в 3-ем бите, поэтому сдвигаем вправо на 3, inputs_in4 => R7.b0"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.AND,
        new Register(7, RegisterField.b0), new Register(7, RegisterField.b0), 1).setComment(
        "получаем значение IN_4, inputs_in4 => R7.b0"));

    // End PRU_INPUTS
    // Call PRU_ABZ_ENCODER
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(7, RegisterField.b0), new Register(6, RegisterField.b1),
        new Register(4, RegisterField.b2)).setComment(
        "abz_changedA => R7.b0, abz_a => R6.b1, abz_prevA => R4.b2"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.NE, orMatch3,
        new Register(7, RegisterField.b0), 0).setComment("abz_changedA => R7.b0"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, endIf2,
        new Register(6, RegisterField.b2), new Register(4, RegisterField.b3)).setComment(
        "abz_b => R6.b2, abz_prevB => R4.b3"));
    ce.visitLabel(orMatch3);

    // Если a или b изменилось
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(3, RegisterField.w0), new Register(3, RegisterField.w0), 1).setComment(
        "abz_counter => R3.w0"));
    //
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(7, RegisterField.b1), new Register(6, RegisterField.b1),
        new Register(6, RegisterField.b2)).setComment(
        "abz_aSameAsB => R7.b1, abz_a => R6.b1, abz_b => R6.b2"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(7, RegisterField.b1), new Register(7, RegisterField.b1), 1).setComment(
        "abz_aSameAsB => R7.b1"));

    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.NE, if5,
        new Register(7, RegisterField.b1), new Register(7, RegisterField.b0)).setComment(
        "abz_aSameAsB => R7.b1, abz_changedA => R7.b0"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(3, RegisterField.w2), new Register(3, RegisterField.w2), 1).setComment(
        "abz_position => R3.w2"));

    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, endIf4,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(if5);
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.SUB,
        new Register(3, RegisterField.w2), new Register(3, RegisterField.w2), 1).setComment(
        "abz_position => R3.w2"));

    ce.visitLabel(endIf4);


    ce.visitLabel(endIf2);

    //
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(4, RegisterField.b2), new Register(6, RegisterField.b1), 0).setComment(
        "abz_prevA => R4.b2, abz_a => R6.b1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(4, RegisterField.b3), new Register(6, RegisterField.b2), 0).setComment(
        "abz_prevB => R4.b3, abz_b => R6.b2"));
    //
    // Call PRU_RTRIG
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.XOR,
        new Register(6, RegisterField.b1), new Register(5, RegisterField.b0), 1).setComment(
        "abz_tmpPRU_RTRIG_0_temp_b0 => R6.b1, abz_tmpPRU_RTRIG_0_mem => R5.b0"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.AND,
        new Register(6, RegisterField.b1), new Register(6, RegisterField.b3),
        new Register(6, RegisterField.b1)).setComment(
        "abz_tmpPRU_RTRIG_0_out => R6.b1, abz_tmpPRU_RTRIG_0_in => R6.b3, abz_tmpPRU_RTRIG_0_temp_b0 => R6.b1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(5, RegisterField.b0), new Register(6, RegisterField.b3), 0).setComment(
        "abz_tmpPRU_RTRIG_0_mem => R5.b0, abz_tmpPRU_RTRIG_0_in => R6.b3"));
    // End PRU_RTRIG
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, endIf6,
        new Register(6, RegisterField.b1), 0).setComment("abz_tmpPRU_RTRIG_0_out => R6.b1"));
    ce.visitInstruction(new LdiInstruction(new Register(3, RegisterField.w2), (short) 0).setComment(
        "abz_position => R3.w2"));
    ce.visitInstruction(new LdiInstruction(new Register(5, RegisterField.b1), (short) 1).setComment(
        "abz_zeroDetected => R5.b1"));

    ce.visitLabel(endIf6);

    //
    // End PRU_ABZ_ENCODER
    // Call PRU_CUTTER
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(6, RegisterField.w1), new Register(3, RegisterField.w0), 0).setComment(
        "cutter_cntr => R6.w1, abz_counter => R3.w0"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, if8,
        new Register(6, RegisterField.b0), 2).setComment("cutter_state => R6.b0"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, elsIf13,
        new Register(6, RegisterField.b0), 0).setComment("cutter_state => R6.b0"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, elsIf15,
        new Register(6, RegisterField.b0), 1).setComment("cutter_state => R6.b0"));
    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, endIf7,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(if8);
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.NE, endIf9,
        new Register(5, RegisterField.b2), 0).setComment("cutter_enable => R5.b2"));
    ce.visitInstruction(new LdiInstruction(new Register(6, RegisterField.b0), (short) 0).setComment(
        "cutter_state => R6.b0"));
    ce.visitInstruction(new LdiInstruction(new Register(1, RegisterField.dw), (short) 0).setComment(
        "cutter_offset => R1"));

    ce.visitLabel(endIf9);

    //

    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, endIf7,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(elsIf13);
    ce.visitInstruction(new LdiInstruction(new Register(1, RegisterField.dw), (short) 0).setComment(
        "cutter_offset => R1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(4, RegisterField.w0), new Register(6, RegisterField.w1), 0).setComment(
        "cutter_prevCntr => R4.w0, cutter_cntr => R6.w1"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, orMatch12,
        new Register(5, RegisterField.b2), 0).setComment("cutter_enable => R5.b2"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.LT, if11,
        new Register(6, RegisterField.w1), 0).setComment("cutter_cntr => R6.w1"));
    ce.visitLabel(orMatch12);

    ce.visitInstruction(new LdiInstruction(new Register(5, RegisterField.b3), (short) 0).setComment(
        "cutter_out => R5.b3"));

    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, endIf10,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(if11);
    ce.visitInstruction(new LdiInstruction(new Register(6, RegisterField.b0), (short) 1).setComment(
        "cutter_state => R6.b0"));
    ce.visitInstruction(new LdiInstruction(new Register(5, RegisterField.b3), (short) 1).setComment(
        "cutter_out => R5.b3"));

    ce.visitLabel(endIf10);


    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, endIf7,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(elsIf15);
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.SUB,
        new Register(7, RegisterField.w0), new Register(6, RegisterField.w1),
        new Register(4, RegisterField.w0)).setComment(
        "cutter_diff => R7.w0, cutter_cntr => R6.w1, cutter_prevCntr => R4.w0"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(4, RegisterField.w0), new Register(6, RegisterField.w1), 0).setComment(
        "cutter_prevCntr => R4.w0, cutter_cntr => R6.w1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(1, RegisterField.dw), new Register(1, RegisterField.dw),
        new Register(7, RegisterField.w0)).setComment("cutter_offset => R1, cutter_diff => R7.w0"));
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.GT, endIf14,
        new Register(1, RegisterField.dw), new Register(2, RegisterField.dw)).setComment(
        "cutter_offset => R1, cutter_runLength => R2"));
    ce.visitInstruction(new LdiInstruction(new Register(5, RegisterField.b3), (short) 0).setComment(
        "cutter_out => R5.b3"));
    ce.visitInstruction(new LdiInstruction(new Register(6, RegisterField.b0), (short) 2).setComment(
        "cutter_state => R6.b0"));

    ce.visitLabel(endIf14);


    ce.visitLabel(endIf7);

    // End PRU_CUTTER
    //
    // Call PRU_OUT1
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.ADD,
        new Register(6, RegisterField.b1), new Register(5, RegisterField.b3), 0).setComment(
        "tmpPRU_OUT1_6_Q => R6.b1, cutter_out => R5.b3"));
    // Ага, ассемблерные вставки
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.NE, if17,
        new Register(6, RegisterField.b1), 0).setComment("tmpPRU_OUT1_6_Q => R6.b1"));
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.CLR,
        new Register(30, RegisterField.dw), new Register(30, RegisterField.dw), 28).setComment(""));

    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, endIf16,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(if17);
    ce.visitInstruction(new ArithmeticInstruction(ArithmeticInstruction.Operation.SET,
        new Register(30, RegisterField.dw), new Register(30, RegisterField.dw), 28).setComment(""));

    ce.visitLabel(endIf16);

    // End PRU_OUT1
    //
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.LOAD,
        new Register(6, RegisterField.b1)).setAddress(3).setOffset(0).setLength(
        1).encode().setComment("dataReady => R6.b1"));
    //
    ce.visitInstruction(new QuickBranchInstruction(QuickBranchInstruction.Operation.EQ, endIf18,
        new Register(6, RegisterField.b1), 0).setComment("dataReady => R6.b1"));
    // Выгружаем параметры
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.STORE,
        new Register(6, RegisterField.b0)).setAddress(3).setOffset(60).setLength(
        1).encode().setComment("cutter_state => R6.b0"));
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.STORE,
        new Register(1, RegisterField.dw)).setAddress(3).setOffset(64).setLength(
        4).encode().setComment("cutter_offset => R1"));
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.STORE,
        new Register(5, RegisterField.b1)).setAddress(3).setOffset(68).setLength(
        1).encode().setComment("abz_zeroDetected => R5.b1"));
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.STORE,
        new Register(3, RegisterField.w2)).setAddress(3).setOffset(72).setLength(
        2).encode().setComment("abz_position => R3.w2"));
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.STORE,
        new Register(3, RegisterField.w0)).setAddress(3).setOffset(76).setLength(
        2).encode().setComment("abz_counter => R3.w0"));

    // Загружаем параметры
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.LOAD,
        new Register(5, RegisterField.b2)).setAddress(3).setOffset(16).setLength(
        1).encode().setComment("cutter_enable => R5.b2"));
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.LOAD,
        new Register(2, RegisterField.dw)).setAddress(3).setOffset(20).setLength(
        4).encode().setComment("cutter_runLength => R2"));

    //
    ce.visitInstruction(new LdiInstruction(new Register(6, RegisterField.b1), (short) 0).setComment(
        "dataReady => R6.b1"));
    ce.visitInstruction(new MemoryTransferInstruction(MemoryTransferInstruction.Operation.STORE,
        new Register(6, RegisterField.b1)).setAddress(3).setOffset(0).setLength(
        1).encode().setComment("dataReady => R6.b1"));

    ce.visitLabel(endIf18);


    ce.visitInstruction(new JumpInstruction(Format2Instruction.Operation.JMP, startWhileBody0,
        new Register(1, RegisterField.dw)).setComment(""));
    ce.visitLabel(endWhile1);


  }
}